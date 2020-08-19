package com.project.config.model.ext;

import com.project.config.DataConfigUtil;
import com.project.config.DataPrimaryKey;

import com.project.config.model.T_demoData;
import com.project.config.model.T_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.lang.String;

/**
* 版本:1.0  MODIFICATION IS NOT ALLOWED
*
* 原文件: demo.xlsx[export_demo二级配置], 对应JSON文件: t_demo.json
*
* 文件创建时间:2020-08-19 16:18:43 创建者:chenjingjun

*/
public class DemoConfig {

    private static Map<DataPrimaryKey, DemoConfig> configs;
    private static List<DemoConfig> configList;
    private static Map<Integer, List<DemoConfig>> primary2Configs;

    public static void reloadConfig(T_demo dataSource){
        Map<DataPrimaryKey, DemoConfig> configMap = DataConfigUtil.reloadConfig(dataSource, DemoConfig.class, DemoConfig::getPrimaryKey);

        List<DemoConfig> configList = configMap.values().stream().sorted(Comparator.comparingLong(actConfig -> actConfig.primaryKey.getLongKey()))
            .collect(Collectors.toList());

        Map<Integer, List<DemoConfig>> listMap = new HashMap<>();
        for (DemoConfig config : configList) {
            List<DemoConfig> configs = listMap.computeIfAbsent(config.primaryKey.getPrimaryId(), key -> new ArrayList<>());
            configs.add(config);
        }

        Map<Integer, List<DemoConfig>> primary2Configs = new HashMap<>();
        for (Map.Entry<Integer, List<DemoConfig>> entry : listMap.entrySet()) {
            entry.getValue().sort(Comparator.comparingInt(actConfig -> actConfig.primaryKey.getSecondaryId()));
            primary2Configs.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }

        DemoConfig.configs = configMap;
        DemoConfig.configList = Collections.unmodifiableList(configList);
        DemoConfig.primary2Configs = primary2Configs;
    }

    public static List<DemoConfig> getAllConfigs() {
        return configList;
    }

    public static DemoConfig getConfig(DataPrimaryKey primaryKey){
        return configs.get(primaryKey);
    }

    public static List<DemoConfig> getConfigs(int primaryId){
        List<DemoConfig> configList = primary2Configs.get(primaryId);
        return configList == null ? Collections.emptyList() : configList;
    }

    public static DemoConfig getFirstConfig(int primaryId){
        List<DemoConfig> configList = getConfigs(primaryId);
        return configList.isEmpty() ? null : configList.get(0);
    }

    public static DemoConfig getLastConfig(int primaryId){
        List<DemoConfig> configList = getConfigs(primaryId);
        return configList.isEmpty() ? null : configList.get(configList.size() - 1);
    }


    /**
    * =================================================== 包装类 =======================================================================
    *
    *  1. 包装类GET方法根据业务需要自己改动
    *
    * **/

    private final T_demoData data;
    private final DataPrimaryKey primaryKey;

    public DemoConfig(T_demoData data) {
        this.data = data;
        this.primaryKey = new DataPrimaryKey(data.getActivityId(), data.getId());
    }

    public DataPrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public int getActivityId(){
        return data.getActivityId();
    }

    public int getId(){
        return data.getId();
    }

    public String getName(){
        return data.getName();
    }

    public int getMaxCount(){
        return data.getMaxCount();
    }

    public int getMaxOnce(){
        return data.getMaxOnce();
    }

    public String getProduct(){
        return data.getProduct();
    }

    public String getCost(){
        return data.getCost();
    }

    public String getType(){
        return data.getType();
    }

    public String getDesc(){
        return data.getDesc();
    }

}
