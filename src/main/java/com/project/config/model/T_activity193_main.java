package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * MODIFICATION IS NOT ALLOWED
 *
 * 原文件: activity193.xlsx[export_193总配置], 对应JSON文件: t_activity193_main.json
 *
 * 文件创建时间:2020-08-11 17:47:08 创建者:chenjingjun

*/
public class T_activity193_main extends Data1Source<T_activity193_mainData> {

    public T_activity193_main() {
        super("t_activity193_main.json" ,T_activity193_mainData::getActivityId);
    }

    @Override
    protected Class<T_activity193_mainData> getJsonClass(){
        return T_activity193_mainData.class;
    }
}
