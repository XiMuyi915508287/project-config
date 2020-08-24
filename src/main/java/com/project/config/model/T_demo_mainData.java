package com.project.config.model;

import java.util.List;
import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: demo.xlsx[export_demo总配置], 对应JSON文件: t_demo_main.json
 *
 * 文件创建时间:2020-08-24 11:14:13 创建者:chenjingjun

*/
public class T_demo_mainData {

    private int activityId;
    private int itemId;
    private List<Integer> summonPoolIds;
    private int currencyCount;
    private int redDotKey;
    private String icon;
    private String btnName;

    public T_demo_mainData() {
    }


    public int getActivityId(){
        return activityId;
    }

    public void setActivityId(int activityId){
        this.activityId = activityId;
    }

    public int getItemId(){
        return itemId;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public List<Integer> getSummonPoolIds(){
        return summonPoolIds;
    }

    public void setSummonPoolIds(List<Integer> summonPoolIds){
        this.summonPoolIds = summonPoolIds;
    }

    public int getCurrencyCount(){
        return currencyCount;
    }

    public void setCurrencyCount(int currencyCount){
        this.currencyCount = currencyCount;
    }

    public int getRedDotKey(){
        return redDotKey;
    }

    public void setRedDotKey(int redDotKey){
        this.redDotKey = redDotKey;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getBtnName(){
        return btnName;
    }

    public void setBtnName(String btnName){
        this.btnName = btnName;
    }
}
