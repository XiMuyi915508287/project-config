package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight.xlsx[export_技能效果], 对应JSON文件: t_skill_effect.json
 *
 * 文件创建时间:2020-08-24 17:44:10 创建者:chenjingjun

*/
public class T_skill_effect extends Data1Source<T_skill_effectData> {

    public T_skill_effect() {
        super("t_skill_effect.json" ,T_skill_effectData::getId);
    }

    @Override
    protected Class<T_skill_effectData> getJsonClass(){
        return T_skill_effectData.class;
    }
}
