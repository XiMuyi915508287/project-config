package com.project.config.model.ext;

import com.project.config.IDataSource;
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
	 * @return 加载失败返回 null.
	 */
	public static <S extends IDataSource, T, K> Map<K, T> realodConfig(S dataSource, Class<T> tClass, Function<T, K> function){
		Map<K, T> configs = null;
		try {
			Method method = dataSource.getClass().getDeclaredMethod("getDataList");
			List dataList = (List) method.invoke(dataSource);
			Map<K, T> map = new HashMap<>(dataList.size());
			for (Object data : dataList) {
				Constructor<T> constructor = tClass.getDeclaredConstructor(data.getClass());
				constructor.setAccessible(true);
				T config = constructor.newInstance(data);
				map.put(function.apply(config), config);
			}
			configs = map;
		}
		catch (Throwable e) {
			logger.error("reload data source:[{}] error.", dataSource.getName(), e);
		}
		return configs;
	}
}
