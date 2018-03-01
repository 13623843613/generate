package com.jy.service.business;
import java.util.List;

import com.jy.common.mybatis.Page;
import com.jy.entity.business.DetectAttach;
/** 
 * <p>Title: DetectAttachService.java</p>
 * <p>Description: </p> 
 * <p>Company:www.baofenqi.com</p> 
 * @author larry
 * @date  :
 * @version :1.0
 */
public interface DetectAttachService{
	
	/**
	 * 分页查询
	 */
	public Page<DetectAttach> findByPage(Page<DetectAttach> page)  throws Exception;
	
	/** 
	 * @Description:	获取信息 不带分页
	 * @param detectAttach
	 * @throws Exception
	 * @return	List<DetectAttach>
	 */
	public List<DetectAttach> getDetectAttachsByParasNoPage(DetectAttach detectAttach) throws Exception;
	
	/** 
	 * @Description:	根据条件获取信息
	 * @param detectAttach
	 * @throws Exception
	 * @return	DetectAttach
	 */
	public DetectAttach findInfo(DetectAttach detectAttach)  throws Exception;	
	/** 
	 * @Description:	添加
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	public void save(DetectAttach detectAttach) throws Exception;
	/** 
	 * @Description:	更新
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	public void update(DetectAttach detectAttach) throws Exception;
	/** 
	 * @Description:	删除
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	public void delete(DetectAttach detectAttach) throws Exception;
	
	/**
	* <p>Description: 批量删除</p>
	* <p>Company:保分期 </p> 
	* @author larry 
	 */
	public void deleteBatch(String chks)  throws Exception;

}
