package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: demo.xlsx[export_demo总配置], 对应JSON文件: t_demo_main.json
 *
 * 文件创建时间:2020-08-24 11:14:13 创建者:chenjingjun

*/
public class T_demo_main extends Data1Source<T_demo_mainData> {

    public T_demo_main() {
        super("t_demo_main.json" ,T_demo_mainData::getActivityId);
    }

    @Override
    protected Class<T_demo_mainData> getJsonClass(){
        return T_demo_mainData.class;
    }
}
