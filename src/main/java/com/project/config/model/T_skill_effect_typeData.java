package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_技能效果类型], 对应JSON文件: t_skill_effect_type.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_effect_typeData {

    /** action编号 **/
    private int id;
    /** 名字 **/
    private String name;
    /** 效果 **/
    private String comment;
    /** 特定执行点 **/
    private int executeOccasion;
    /** 命中抵抗对其有效？	0无效 1有效 **/
    private boolean hitOrResistEffect;

    public T_skill_effect_typeData() {
    }


    public int getId(){
        return id;
    }


    public String getName(){
        return name;
    }


    public String getComment(){
        return comment;
    }


    public int getExecuteOccasion(){
        return executeOccasion;
    }


    public boolean isHitOrResistEffect(){
        return hitOrResistEffect;
    }

}
