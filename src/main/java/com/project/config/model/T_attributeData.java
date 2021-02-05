package com.project.config.model;


/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: attribute0.xlsx[export_裸体属性], 对应JSON文件: t_attribute.json
 *
 * 文件创建时间:2021-01-23 16:17:01 创建者:chenjingjun

*/
public class T_attributeData {

    /** ID **/
    private int id;
    /** 单位类型 **/
    private int type;
    /** 等级 **/
    private int level;
    /** 血量 **/
    private int hp;
    /** 攻击 **/
    private int atk;
    /** 防御 **/
    private int def;
    /** 暴击 **/
    private int critic;
    /** 暴击伤害 **/
    private int critic_dmg;
    /** 闪避 **/
    private int dodge;
    /** 效果命中 **/
    private int effect_hit;
    /** 效果抵抗 **/
    private int effect_resist;

    public T_attributeData() {
    }


    public int getId(){
        return id;
    }


    public int getType(){
        return type;
    }


    public int getLevel(){
        return level;
    }


    public int getHp(){
        return hp;
    }


    public int getAtk(){
        return atk;
    }


    public int getDef(){
        return def;
    }


    public int getCritic(){
        return critic;
    }


    public int getCritic_dmg(){
        return critic_dmg;
    }


    public int getDodge(){
        return dodge;
    }


    public int getEffect_hit(){
        return effect_hit;
    }


    public int getEffect_resist(){
        return effect_resist;
    }

}
