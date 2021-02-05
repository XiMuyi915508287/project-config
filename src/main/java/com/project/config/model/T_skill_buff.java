package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: skill_fight0.xlsx[export_buff], 对应JSON文件: t_skill_buff.json
 *
 * 文件创建时间:2021-02-05 10:48:43 创建者:chenjingjun

*/
public class T_skill_buff extends Data1Source<T_skill_buffData> {

    public T_skill_buff() {
        super("t_skill_buff.json" ,T_skill_buffData::getId);
    }

    @Override
    protected Class<T_skill_buffData> getJsonClass(){
        return T_skill_buffData.class;
    }
}
