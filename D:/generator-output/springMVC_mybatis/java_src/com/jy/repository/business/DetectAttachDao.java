package com.jy.repository.business;

import org.springframework.stereotype.Repository;
import com.jy.repository.base.BaseDao;
import com.jy.entity.business.DetectAttach;
@Repository
public interface DetectAttachDao extends BaseDao<DetectAttach>{
	
	/** 
	 * @Description:	根据条件获取信息
	 * @param detectAttach
	 * @throws Exception
	 * @return	DetectAttach
	 */
	public DetectAttach getDetectAttachByParas(DetectAttach detectAttach) throws Exception;
	/** 
	 * @Description:	添加
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	public void insertSelective(DetectAttach detectAttach) throws Exception;
	/** 
	 * @Description:	更新
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	//public void update(DetectAttach detectAttach) throws Exception;
	/** 
	 * @Description:	删除
	 * @param detectAttach
	 * @throws Exception
	 * @return	void
	 */
	//public void delete(DetectAttach detectAttach) throws Exception;

}
