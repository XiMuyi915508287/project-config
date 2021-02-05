package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight.xlsx[export_技能效果], 对应JSON文件: t_skill_effect.json
 *
 * 文件创建时间:2020-08-24 17:44:10 创建者:chenjingjun

*/
public class T_skill_effectData {

    private int id;
    private String name;
    private String comment;
    private int executeOccasion;
    private boolean hitOrResistEffect;

    public T_skill_effectData() {
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

    public String getComment(){
        return comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public int getExecuteOccasion(){
        return executeOccasion;
    }

    public void setExecuteOccasion(int executeOccasion){
        this.executeOccasion = executeOccasion;
    }

    public boolean getHitOrResistEffect(){
        return hitOrResistEffect;
    }

    public void setHitOrResistEffect(boolean hitOrResistEffect){
        this.hitOrResistEffect = hitOrResistEffect;
    }
}
