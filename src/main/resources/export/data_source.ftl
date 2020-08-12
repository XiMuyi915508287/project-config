package ${javaPackage};

import com.project.config.Data${primaryCount}Source;
import java.util.function.Function;

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: ${filename}, 对应JSON文件: ${name}
 *
 * ${annotation}
*/
public class ${javaClassName} extends Data${primaryCount}Source<${javaDataClassName}> {

    public ${javaClassName}() {
        super("${name}"<#list fieldList as field><#if field.fieldConfig.primaryKey> ,${javaDataClassName}::${field.fieldConfig.methodGet}</#if></#list>);
    }

    @Override
    protected Class<${javaDataClassName}> getJsonClass(){
        return ${javaDataClassName}.class;
    }
}
