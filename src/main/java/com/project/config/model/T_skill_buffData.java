package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_buff], 对应JSON文件: t_skill_buff.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_buffData {

    /** action编号 **/
    private int id;
    /** 图标ID **/
    private String iconId;
    /** 特效ID **/
    private String effectId;
    /** 客户端显示 **/
    private String name;
    /** 正面、负面等 **/
    private int generaId;
    /** 效果类型 **/
    private int type;
    /** 触发条件 **/
    private int condition;
    /** 效果数值 **/
    private int value;
    /** 最大回合 **/
    private int maxRound;
    /** 特性 **/
    private String features;

    public T_skill_buffData() {
    }


    public int getId(){
        return id;
    }


    public String getIconId(){
        return iconId;
    }


    public String getEffectId(){
        return effectId;
    }


    public String getName(){
        return name;
    }


    public int getGeneraId(){
        return generaId;
    }


    public int getType(){
        return type;
    }


    public int getCondition(){
        return condition;
    }


    public int getValue(){
        return value;
    }


    public int getMaxRound(){
        return maxRound;
    }


    public String getFeatures(){
        return features;
    }

}
