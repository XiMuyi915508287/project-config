package ${javaPackage};

<#list fieldList as field>
    <#if field.typeConfig.typeImport??>
import ${field.typeConfig.typeImport};
    </#if>
</#list>

/**
* 导出的文件: ${filename}, MODIFICATION IS NOT ALLOWED
* ${annotation}
*/
public class ${javaClassName} {

<#list fieldList as field>
    private ${field.typeConfig.typeClass} ${field.fieldConfig.name};
</#list>

    public ${javaClassName}() {
    }

<#list fieldList as field>

    public ${field.typeConfig.typeClass} ${field.fieldConfig.methodGet}(){
        return ${field.fieldConfig.name};
    }

    public void ${field.fieldConfig.methodSet}(${field.typeConfig.typeClass} ${field.fieldConfig.name}){
        this.${field.fieldConfig.name} = ${field.fieldConfig.name};
    }
</#list>
}
