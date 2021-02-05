package com.project.config.model;

import java.lang.String;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_技能], 对应JSON文件: t_skill.json
 *
 * 文件创建时间:2021-02-05 10:48:42 创建者:chenjingjun

*/
public class T_skillData {

    /** 技能ID **/
    private int id;
    /** 是否是大招 **/
    private boolean superSkill;
    /** 是否是	aoe **/
    private int isAoe;
    /** 技能类型 **/
    private int type;
    /** 初始冷却时间 **/
    private int initCd;
    /** 冷却时间 **/
    private int cd;
    /** 可否增减冷却 **/
    private boolean ignoreChangeCD;
    /** 技能系数 **/
    private int damageRate;
    /** 伤害目标 **/
    private int effectTarget;
    /** 逻辑条件1 **/
    private int condition1;
    /** 逻辑效果1 **/
    private String effect1;
    /** 逻辑1概率 **/
    private int effectRate1;
    /** 逻辑1目标 **/
    private int effectTarget1;
    /** 逻辑条件2 **/
    private int condition2;
    /** 逻辑效果2 **/
    private String effect2;
    /** 逻辑2概率 **/
    private int effectRate2;
    /** 逻辑2目标 **/
    private int effectTarget2;
    /** 逻辑条件3 **/
    private int condition3;
    /** 逻辑效果3 **/
    private String effect3;
    /** 逻辑3概率 **/
    private int effectRate3;
    /** 逻辑3目标 **/
    private int effectTarget3;
    /** 逻辑条件4 **/
    private int condition4;
    /** 逻辑效果4 **/
    private String effect4;
    /** 逻辑4概率 **/
    private int effectRate4;
    /** 逻辑4目标 **/
    private int effectTarget4;
    /** 逻辑条件5 **/
    private int condition5;
    /** 逻辑效果5 **/
    private String effect5;
    /** 逻辑5概率 **/
    private int effectRate5;
    /** 逻辑5目标 **/
    private int effectTarget5;
    /** 是否光环 **/
    private int isAura;
    /** 不播放技能动作 **/
    private boolean notDoAction;
    /** 更换技能id **/
    private int changeSkillId;

    public T_skillData() {
    }


    public int getId(){
        return id;
    }


    public boolean isSuperSkill(){
        return superSkill;
    }


    public int getIsAoe(){
        return isAoe;
    }


    public int getType(){
        return type;
    }


    public int getInitCd(){
        return initCd;
    }


    public int getCd(){
        return cd;
    }


    public boolean isIgnoreChangeCD(){
        return ignoreChangeCD;
    }


    public int getDamageRate(){
        return damageRate;
    }


    public int getEffectTarget(){
        return effectTarget;
    }


    public int getCondition1(){
        return condition1;
    }


    public String getEffect1(){
        return effect1;
    }


    public int getEffectRate1(){
        return effectRate1;
    }


    public int getEffectTarget1(){
        return effectTarget1;
    }


    public int getCondition2(){
        return condition2;
    }


    public String getEffect2(){
        return effect2;
    }


    public int getEffectRate2(){
        return effectRate2;
    }


    public int getEffectTarget2(){
        return effectTarget2;
    }


    public int getCondition3(){
        return condition3;
    }


    public String getEffect3(){
        return effect3;
    }


    public int getEffectRate3(){
        return effectRate3;
    }


    public int getEffectTarget3(){
        return effectTarget3;
    }


    public int getCondition4(){
        return condition4;
    }


    public String getEffect4(){
        return effect4;
    }


    public int getEffectRate4(){
        return effectRate4;
    }


    public int getEffectTarget4(){
        return effectTarget4;
    }


    public int getCondition5(){
        return condition5;
    }


    public String getEffect5(){
        return effect5;
    }


    public int getEffectRate5(){
        return effectRate5;
    }


    public int getEffectTarget5(){
        return effectTarget5;
    }


    public int getIsAura(){
        return isAura;
    }


    public boolean isNotDoAction(){
        return notDoAction;
    }


    public int getChangeSkillId(){
        return changeSkillId;
    }

}
