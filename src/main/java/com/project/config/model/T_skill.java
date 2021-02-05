package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_技能], 对应JSON文件: t_skill.json
 *
 * 文件创建时间:2021-02-05 10:48:42 创建者:chenjingjun

*/
public class T_skill extends Data1Source<T_skillData> {

    public T_skill() {
        super("t_skill.json" ,T_skillData::getId);
    }

    @Override
    protected Class<T_skillData> getJsonClass(){
        return T_skillData.class;
    }
}
