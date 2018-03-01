<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameFirstLower = className?uncap_first> 
<#assign pkJavaType = table.idColumn.javaType> 

package ${basepackage}.entity.business;  
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ${className}  implements Serializable{
	
    <#list table.columns as column>
    /**
     * ${column.remarks}
     */
    private ${column.simpleJavaType} ${column.columnNameLower}; 
    </#list>
}
