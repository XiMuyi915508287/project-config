package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_buff类型], 对应JSON文件: t_skill_buff_type.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_buff_type extends Data1Source<T_skill_buff_typeData> {

    public T_skill_buff_type() {
        super("t_skill_buff_type.json" ,T_skill_buff_typeData::getId);
    }

    @Override
    protected Class<T_skill_buff_typeData> getJsonClass(){
        return T_skill_buff_typeData.class;
    }
}
