package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_触发条件], 对应JSON文件: t_skill_condition.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_conditionData {

    /** action编号 **/
    private int id;
    /** 触发条件 **/
    private String comment;
    /** 触发逻辑 **/
    private String type;
    /** 参数 **/
    private String param;

    public T_skill_conditionData() {
    }


    public int getId(){
        return id;
    }


    public String getComment(){
        return comment;
    }


    public String getType(){
        return type;
    }


    public String getParam(){
        return param;
    }

}
