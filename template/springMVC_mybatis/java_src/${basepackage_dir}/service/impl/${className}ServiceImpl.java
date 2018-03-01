<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameFirstLower = className?uncap_first> 
package ${basepackage}.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.jy.common.mybatis.Page;
import ${basepackage}.repository.business.${className}Dao;
import ${basepackage}.entity.business.${className};
import ${basepackage}.service.business.${className}Service;

/** 
 * <p>Title: ${className}ServiceImpl.java</p>
 * <p>Description: </p> 
 * <p>Company:www.baofenqi.com</p> 
 * @author larry
 * @date  :
 * @version :1.0
 */
@RestController
public class ${className}ServiceImpl implements ${className}Service {
	@Autowired
	${className}Dao ${classNameFirstLower}Dao;

	/**
	 * 分页查询
	 */
	@Override
	public Page<${className}> findByPage(Page<${className}> page)  throws Exception{
		${className} ${classNameFirstLower} = page.getParam();
		page.setResults(${classNameFirstLower}Dao.findByPage(${classNameFirstLower},page));
		return page;
	}
	
	/**
	 * 查询不带分页
	 */
	@Override
	public List<${className}> get${className}sByParasNoPage(${className} ${classNameFirstLower}) throws Exception {
		return ${classNameFirstLower}Dao.find(${classNameFirstLower});
	}
	
	/**
	 * 查询对象
	 */
	@Override
	public ${className} findInfo(${className} ${classNameFirstLower})  throws Exception{
		return ${classNameFirstLower}Dao.findInfo(${classNameFirstLower});
	}

	/**
	 * 保存对象
	 */
	@Override
	public void save(${className} ${classNameFirstLower}) throws Exception {
		${classNameFirstLower}Dao.insertSelective(${classNameFirstLower});
	}
	
	/**
	 * 更新对象
	 */
	@Override
	public void update(${className} ${classNameFirstLower}) throws Exception {
		${classNameFirstLower}Dao.update(${classNameFirstLower});
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(${className} ${classNameFirstLower}) throws Exception {
		${classNameFirstLower}Dao.delete(${classNameFirstLower});
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String chks)  throws Exception{
		if(StringUtils.isNotBlank(chks)){
			String[] chk =chks.split(",");
			List<${className}> ids=new ArrayList<${className}>();
			for(String s:chk){
				${className} m=new ${className}();
				m.setId(s);
				ids.add(m);
			}
			${classNameFirstLower}Dao.deleteBatch(ids);
		}
	}
}
