package com.project.config.model;

import java.util.List;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_buff类型], 对应JSON文件: t_skill_buff_type.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_buff_typeData {

    /** 效果类型 **/
    private int id;
    /** 策略 **/
    private int strategy;
    /** 互斥效果类型 **/
    private List<Integer> excludeTypes;
    /** 拒绝效果类型 **/
    private List<Integer> rejectTypes;
    /** 扣减回合数时机	(自己给的) **/
    private int fromSelfDecRoundPoint;
    /** 扣减回合数时机	(队友给的) **/
    private int fromTeamMateDecRoundPoint;
    /** 扣减回合数时机	(敌人给的) **/
    private int fromEnemyDecRoundPoint;
    /** 能否清除	1能 0不能 **/
    private boolean canRemove;
    /** 能否改变回合数	1能 0不能 **/
    private boolean canChangeRound;
    /** 能否忽略	1能 0不能 **/
    private boolean canIgnore;

    public T_skill_buff_typeData() {
    }


    public int getId(){
        return id;
    }


    public int getStrategy(){
        return strategy;
    }


    public List<Integer> getExcludeTypes(){
        return excludeTypes;
    }


    public List<Integer> getRejectTypes(){
        return rejectTypes;
    }


    public int getFromSelfDecRoundPoint(){
        return fromSelfDecRoundPoint;
    }


    public int getFromTeamMateDecRoundPoint(){
        return fromTeamMateDecRoundPoint;
    }


    public int getFromEnemyDecRoundPoint(){
        return fromEnemyDecRoundPoint;
    }


    public boolean isCanRemove(){
        return canRemove;
    }


    public boolean isCanChangeRound(){
        return canChangeRound;
    }


    public boolean isCanIgnore(){
        return canIgnore;
    }

}
