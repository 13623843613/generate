<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameFirstLower = className?uncap_first>
package ${basepackage}.repository.business;

import org.springframework.stereotype.Repository;
import ${basepackage}.repository.base.BaseDao;
import ${basepackage}.entity.business.${className};
@Repository
public interface ${className}Dao extends BaseDao<${className}>{

}
