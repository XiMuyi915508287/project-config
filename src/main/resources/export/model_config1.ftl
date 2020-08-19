package ${javaPackage};

import com.project.config.DataConfigUtil;

import ${javaDataPackage}.${javaDataClassName};
import ${javaDataPackage}.${javaSourceClassName};

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

<#list fieldList as field>
    <#if field.typeConfig.typeImport??>
import ${field.typeConfig.typeImport};
    </#if>
</#list>

/**
* 版本:1.0  MODIFICATION IS NOT ALLOWED
*
* 原文件: ${filename}, 对应JSON文件: ${name}
*
* ${annotation}
*/

public class ${javaClassName} {

    private static Map<Integer, ${javaClassName}> configs;
    private static List<${javaClassName}> configList;

    public static void reloadConfig(${javaSourceClassName} dataSource){
        Map<Integer, ${javaClassName}> configMap = DataConfigUtil.reloadConfig(dataSource, ${javaClassName}.class, ${javaClassName}::getPrimaryId);

        List<${javaClassName}> configList = configMap.values().stream().sorted(Comparator.comparing(${javaClassName}::getPrimaryId))
        .collect(Collectors.toList());

        ${javaClassName}.configs = configMap;
        ${javaClassName}.configList = Collections.unmodifiableList(configList);
    }

    public static List<${javaClassName}> getAllConfigs() {
        return configList;
    }

    public static ${javaClassName} getConfig(int primaryKey){
        return configs.get(primaryKey);
    }

    public static ${javaClassName} getFirstConfig(int primaryId){
        return configList.isEmpty() ? null : configList.get(0);
    }

    public static ${javaClassName} getLastConfig(int primaryId){
        return configList.isEmpty() ? null : configList.get(configList.size() - 1);
    }

    /**
    * ==================================== 包装类 ========================================================
    * 1. 包装类GET方法根据业务需要自己改动
    *
    * **/

    private final ${javaDataClassName} data;

    public ${javaClassName}(${javaDataClassName} data) {
        this.data = data;
    }

    public int getPrimaryId() {
        return data.${fieldList[0].fieldConfig.methodGet}();
    }

<#list fieldList as field>
    public ${field.typeConfig.typeClass} ${field.fieldConfig.methodGet}(){
        return data.${field.fieldConfig.methodGet}();
    }

</#list>
}
