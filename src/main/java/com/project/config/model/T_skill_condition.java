package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_触发条件], 对应JSON文件: t_skill_condition.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_condition extends Data1Source<T_skill_conditionData> {

    public T_skill_condition() {
        super("t_skill_condition.json" ,T_skill_conditionData::getId);
    }

    @Override
    protected Class<T_skill_conditionData> getJsonClass(){
        return T_skill_conditionData.class;
    }
}
