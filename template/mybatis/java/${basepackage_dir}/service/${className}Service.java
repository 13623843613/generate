<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameFirstLower = className?uncap_first> 
package ${basepackage}.service.business;
import java.util.List;

import com.jy.common.mybatis.Page;
import ${basepackage}.entity.business.${className};
/**
 * @author xiaotian
 * @create 2018-03-02 上午10:24
 */
public interface ${className}Service{
	
	/**
	 * 分页查询
	 */
	public Page<${className}> findByPage(Page<${className}> page)  throws Exception;
	
	/** 
	 * @Description:	获取信息 不带分页
	 * @param ${classNameFirstLower}
	 * @return	List<${className}>
	 */
	public List<${className}> get${className}sByParasNoPage(${className} ${classNameFirstLower}) throws Exception;
	
	/** 
	 * @Description:	根据条件获取信息
	 * @param ${classNameFirstLower}
	 * @return	${className}
	 */
	public ${className} findInfo(${className} ${classNameFirstLower})  throws Exception;	
	/** 
	 * @Description:	添加
	 * @param ${classNameFirstLower}
	 * @return	void
	 */
	public void save(${className} ${classNameFirstLower}) throws Exception;
	/** 
	 * @Description:	更新
	 * @param ${classNameFirstLower}
]	 * @return	void
	 */
	public void update(${className} ${classNameFirstLower}) throws Exception;
	/** 
	 * @Description:	删除
	 * @param ${classNameFirstLower}
	 * @return	void
	 */
	public void delete(${className} ${classNameFirstLower}) throws Exception;
	
	/**
	* Description: 批量删除
	 */
	public void deleteBatch(String chks)  throws Exception;

}
