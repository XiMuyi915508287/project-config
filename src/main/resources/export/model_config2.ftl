package ${javaPackage};

import com.project.config.DataConfigUtil;
import com.project.config.DataPrimaryKey;

import ${javaDataPackage}.${javaDataClassName};
import ${javaDataPackage}.${javaSourceClassName};

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

    private static Map<DataPrimaryKey, ${javaClassName}> configs;
    private static List<${javaClassName}> configList;
    private static Map<Integer, List<${javaClassName}>> primary2Configs;

    public static void reloadConfig(${javaSourceClassName} dataSource){
        Map<DataPrimaryKey, ${javaClassName}> configMap = DataConfigUtil.reloadConfig(dataSource, ${javaClassName}.class, ${javaClassName}::getPrimaryKey);

        List<${javaClassName}> configList = configMap.values().stream().sorted(Comparator.comparingLong(actConfig -> actConfig.primaryKey.getLongKey()))
            .collect(Collectors.toList());

        Map<Integer, List<${javaClassName}>> listMap = new HashMap<>();
        for (${javaClassName} config : configList) {
            List<${javaClassName}> configs = listMap.computeIfAbsent(config.primaryKey.getPrimaryId(), key -> new ArrayList<>());
            configs.add(config);
        }

        Map<Integer, List<${javaClassName}>> primary2Configs = new HashMap<>();
        for (Map.Entry<Integer, List<${javaClassName}>> entry : listMap.entrySet()) {
            entry.getValue().sort(Comparator.comparingInt(actConfig -> actConfig.primaryKey.getSecondaryId()));
            primary2Configs.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }

        ${javaClassName}.configs = configMap;
        ${javaClassName}.configList = Collections.unmodifiableList(configList);
        ${javaClassName}.primary2Configs = primary2Configs;
    }

    public static List<${javaClassName}> getAllConfigs() {
        return configList;
    }

    public static ${javaClassName} getConfig(DataPrimaryKey primaryKey){
        return configs.get(primaryKey);
    }

    public static List<${javaClassName}> getConfigs(int primaryId){
        List<${javaClassName}> configList = primary2Configs.get(primaryId);
        return configList == null ? Collections.emptyList() : configList;
    }

    public static ${javaClassName} getFirstConfig(int primaryId){
        List<${javaClassName}> configList = getConfigs(primaryId);
        return configList.isEmpty() ? null : configList.get(0);
    }

    public static ${javaClassName} getLastConfig(int primaryId){
        List<${javaClassName}> configList = getConfigs(primaryId);
        return configList.isEmpty() ? null : configList.get(configList.size() - 1);
    }


    /**
    * =================================================== 包装类 =======================================================================
    *
    *  1. 包装类GET方法根据业务需要自己改动
    *
    * **/

    private final ${javaDataClassName} data;
    private final DataPrimaryKey primaryKey;

    public ${javaClassName}(${javaDataClassName} data) {
        this.data = data;
        this.primaryKey = new DataPrimaryKey(data.getActivityId(), data.getId());
    }

    public DataPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

<#list fieldList as field>
    public ${field.typeConfig.typeClass} ${field.fieldConfig.methodGet}(){
        return data.${field.fieldConfig.methodGet}();
    }

</#list>
}
