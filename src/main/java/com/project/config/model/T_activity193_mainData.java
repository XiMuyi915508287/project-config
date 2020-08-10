package com.project.config.model;

import java.util.List;
import java.lang.String;
import java.lang.String;

/**
* 导出的文件: activity193.xlsx[export_193总配置], MODIFICATION IS NOT ALLOWED
* 文件创建时间:2020-08-10 17:52:14 创建者:chenjingjun

*/
public class T_activity193_mainData {

    private int activityId;
    private int itemId;
    private List<Integer> summonPoolIds;
    private int currencyCount;
    private int redDotKey;
    private String icon;
    private String btnName;

    public T_activity193_mainData() {
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
