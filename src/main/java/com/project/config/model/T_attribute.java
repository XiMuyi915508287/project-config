package com.project.config.model;

import com.project.config.Data1Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: attribute0.xlsx[export_裸体属性], 对应JSON文件: t_attribute.json
 *
 * 文件创建时间:2021-01-23 16:17:01 创建者:chenjingjun

*/
public class T_attribute extends Data1Source<T_attributeData> {

    public T_attribute() {
        super("t_attribute.json" ,T_attributeData::getId);
    }

    @Override
    protected Class<T_attributeData> getJsonClass(){
        return T_attributeData.class;
    }
}
