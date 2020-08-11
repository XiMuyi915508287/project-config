package com.project.config.model;

import com.project.config.Data2Source;
import java.util.function.Function;

/**
 * MODIFICATION IS NOT ALLOWED
 *
 * 原文件: activity193.xlsx[export_193商店配置], 对应JSON文件: t_activity193.json
 *
 * 文件创建时间:2020-08-11 17:47:09 创建者:chenjingjun

*/
public class T_activity193 extends Data2Source<T_activity193Data> {

    public T_activity193() {
        super("t_activity193.json" ,T_activity193Data::getActivityId ,T_activity193Data::getId);
    }

    @Override
    protected Class<T_activity193Data> getJsonClass(){
        return T_activity193Data.class;
    }
}
