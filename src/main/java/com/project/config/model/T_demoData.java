package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: demo.xlsx[export_demo二级配置], 对应JSON文件: t_demo.json
 *
 * 文件创建时间:2020-08-19 16:18:43 创建者:chenjingjun

*/
public class T_demoData {

    private int activityId;
    private int id;
    private String name;
    private int maxCount;
    private int maxOnce;
    private String product;
    private String cost;
    private String type;
    private String desc;

    public T_demoData() {
    }


    public int getActivityId(){
        return activityId;
    }

    public void setActivityId(int activityId){
        this.activityId = activityId;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMaxCount(){
        return maxCount;
    }

    public void setMaxCount(int maxCount){
        this.maxCount = maxCount;
    }

    public int getMaxOnce(){
        return maxOnce;
    }

    public void setMaxOnce(int maxOnce){
        this.maxOnce = maxOnce;
    }

    public String getProduct(){
        return product;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public String getCost(){
        return cost;
    }

    public void setCost(String cost){
        this.cost = cost;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
}
