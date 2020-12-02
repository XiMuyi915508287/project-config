package com.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DataConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(DataConfigUtil.class);

	/**
	 * @param dataSource
	 * @param tClass
	 * @param function
	 * @param <S>
	 * @param <T>
	 * @param <K>
	 * @return
	 */
	public static <S extends IDataSource, T, K> Map<K, T> reloadConfig(S dataSource, Class<T> tClass, Function<T, K> function){
		try {
			Method method = dataSource.getClass().getSuperclass().getDeclaredMethod("getDataList");
			List dataList = (List) method.invoke(dataSource);
			Map<K, T> configs = new HashMap<>(dataList.size());
			for (Object data : dataList) {
				Constructor<T> constructor = tClass.getDeclaredConstructor(data.getClass());
				constructor.setAccessible(true);
				T config = constructor.newInstance(data);
				configs.put(function.apply(config), config);
			}
			return configs;
		}
		catch (Throwable e) {
			throw new RuntimeException("reload data source:" + dataSource.getName(), e);
		}
	}
}
