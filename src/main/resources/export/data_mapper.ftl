package com.project.core.config.data;

import com.project.config.IDataSource;
<#list classConfigList as classConfig>
import ${classConfig.dataClass.name};
</#list>
<#list classConfigList as classConfig>
    import ${classConfig.configClass.name};
</#list>

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
* 版本:1.0  MODIFICATION IS NOT ALLOWED
*
* ${annotation}
*/
public class DataMapper {

    private static final Logger logger = LoggerFactory.getLogger(DataMapper.class);

    private static final Map<String, ConfigClass> name2ConfigClass = new HashMap<>();

    static {
<#list classConfigList as classConfig>
        addClass(${classConfig.dataClass.simpleName}.class, ${classConfig.configClass.simpleName}.class);
</#list>
    }

    public static Map<String, ConfigClass> getName2ConfigClass() {
        return new HashMap<>(name2ConfigClass);
    }

    private static void addClass(Class<? extends IDataSource> dataClass, Class<?> configClass){
        try {
            IDataSource dataSource = dataClass.newInstance();
            String name = dataSource.getName();
            name2ConfigClass.put(name, new ConfigClass(name, dataClass, configClass));
        }
        catch (InstantiationException | IllegalAccessException e) {
            logger.error("dataClass:{} configClass:{}", dataClass.getName(), configClass.getName(), e);
        }
    }

    static void onDataSourceReload(IDataSource dataSource) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ConfigClass configClass = name2ConfigClass.get(dataSource.getName());
        if (configClass == null){
            return;
        }
        Method method = configClass.getConfigClass().getMethod("reloadConfig", dataSource.getClass());
        method.invoke(null, dataSource);
    }

    public static class ConfigClass {

        private final String name;
        private final Class<? extends IDataSource> dataClass;
        private final Class<?> configClass;

        public ConfigClass(String name, Class<? extends IDataSource> dataClass, Class<?> configClass) {
            this.name = name;
            this.dataClass = dataClass;
            this.configClass = configClass;
        }

        public String getName() {
            return name;
        }

        public Class<? extends IDataSource> getDataClass() {
            return dataClass;
        }

        public Class<?> getConfigClass() {
            return configClass;
        }
    }
}

