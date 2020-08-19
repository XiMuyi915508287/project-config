package com.project.config.model.ext;

import com.project.config.DataConfigUtil;

import com.project.config.model.T_demo_mainData;
import com.project.config.model.T_demo_main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.List;
import java.lang.String;

/**
* 版本:1.0  MODIFICATION IS NOT ALLOWED
*
* 原文件: demo.xlsx[export_demo总配置], 对应JSON文件: t_demo_main.json
*
* 文件创建时间:2020-08-19 16:18:43 创建者:chenjingjun

*/

public class DemoMainConfig {

    private static Map<Integer, DemoMainConfig> configs;
    private static List<DemoMainConfig> configList;

    public static void reloadConfig(T_demo_main dataSource){
        Map<Integer, DemoMainConfig> configMap = DataConfigUtil.reloadConfig(dataSource, DemoMainConfig.class, DemoMainConfig::getPrimaryId);

        List<DemoMainConfig> configList = configMap.values().stream().sorted(Comparator.comparing(DemoMainConfig::getPrimaryId))
        .collect(Collectors.toList());

        DemoMainConfig.configs = configMap;
        DemoMainConfig.configList = Collections.unmodifiableList(configList);
    }

    public static List<DemoMainConfig> getAllConfigs() {
        return configList;
    }

    public static DemoMainConfig getConfig(int primaryKey){
        return configs.get(primaryKey);
    }

    public static DemoMainConfig getFirstConfig(int primaryId){
        return configList.isEmpty() ? null : configList.get(0);
    }

    public static DemoMainConfig getLastConfig(int primaryId){
        return configList.isEmpty() ? null : configList.get(configList.size() - 1);
    }

    /**
    * ==================================== 包装类 ========================================================
    * 1. 包装类GET方法根据业务需要自己改动
    *
    * **/

    private final T_demo_mainData data;

    public DemoMainConfig(T_demo_mainData data) {
        this.data = data;
    }

    public int getPrimaryId() {
        return data.getActivityId();
    }

    public int getActivityId(){
        return data.getActivityId();
    }

    public int getItemId(){
        return data.getItemId();
    }

    public List<Integer> getSummonPoolIds(){
        return data.getSummonPoolIds();
    }

    public int getCurrencyCount(){
        return data.getCurrencyCount();
    }

    public int getRedDotKey(){
        return data.getRedDotKey();
    }

    public String getIcon(){
        return data.getIcon();
    }

    public String getBtnName(){
        return data.getBtnName();
    }

}
