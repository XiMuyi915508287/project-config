package com.project.config.model;

import com.project.config.Data2Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: demo.xlsx[export_demo二级配置], 对应JSON文件: t_demo.json
 *
 * 文件创建时间:2020-08-19 16:18:43 创建者:chenjingjun

*/
public class T_demo extends Data2Source<T_demoData> {

    public T_demo() {
        super("t_demo.json" ,T_demoData::getActivityId ,T_demoData::getId);
    }

    @Override
    protected Class<T_demoData> getJsonClass(){
        return T_demoData.class;
    }
}
