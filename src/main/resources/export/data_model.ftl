package ${javaPackage};

<#list fieldList as field>
    <#if field.typeConfig.typeImport??>
import ${field.typeConfig.typeImport};
    </#if>
</#list>

/**
 * 版本:1.0  MODIFICATION IS NOT ALLOWED
 *
 * 原文件: ${filename}, 对应JSON文件: ${name}
 *
 * ${annotation}
*/
public class ${javaClassName} {

<#list fieldList as field>
    /** ${field.fieldConfig.annotation} **/
    private ${field.typeConfig.typeClass} ${field.fieldConfig.name};
</#list>

    public ${javaClassName}() {
    }

<#list fieldList as field>

    public ${field.typeConfig.typeClass} ${field.fieldConfig.methodGet}(){
        return ${field.fieldConfig.name};
    }

    <#--public void ${field.fieldConfig.methodSet}(${field.typeConfig.typeClass} ${field.fieldConfig.name}){-->
        <#--this.${field.fieldConfig.name} = ${field.fieldConfig.name};-->
    <#--}-->
</#list>
}
