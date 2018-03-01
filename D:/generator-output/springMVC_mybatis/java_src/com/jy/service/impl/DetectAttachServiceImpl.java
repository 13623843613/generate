package com.jy.service.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.jy.common.mybatis.Page;
import com.jy.repository.business.DetectAttachDao;
import com.jy.entity.business.DetectAttach;
import com.jy.service.business.DetectAttachService;

/** 
 * <p>Title: DetectAttachServiceImpl.java</p>
 * <p>Description: </p> 
 * <p>Company:www.baofenqi.com</p> 
 * @author larry
 * @date  :
 * @version :1.0
 */
@RestController
public class DetectAttachServiceImpl implements DetectAttachService {
	@Autowired
	DetectAttachDao detectAttachDao;

	/**
	 * 分页查询
	 */
	@Override
	public Page<DetectAttach> findByPage(Page<DetectAttach> page)  throws Exception{
		DetectAttach detectAttach = page.getParam();
		page.setResults(detectAttachDao.findByPage(detectAttach,page));
		return page;
	}
	
	/**
	 * 查询不带分页
	 */
	@Override
	public List<DetectAttach> getDetectAttachsByParasNoPage(DetectAttach detectAttach) throws Exception {
		return detectAttachDao.find(detectAttach);
	}
	
	/**
	 * 查询对象
	 */
	@Override
	public DetectAttach findInfo(DetectAttach detectAttach)  throws Exception{
		return detectAttachDao.findInfo(detectAttach);
	}

	/**
	 * 保存对象
	 */
	@Override
	public void save(DetectAttach detectAttach) throws Exception {
		detectAttachDao.insertSelective(detectAttach);
	}
	
	/**
	 * 更新对象
	 */
	@Override
	public void update(DetectAttach detectAttach) throws Exception {
		detectAttachDao.update(detectAttach);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(DetectAttach detectAttach) throws Exception {
		detectAttachDao.delete(detectAttach);
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(String chks)  throws Exception{
		if(StringUtils.isNotBlank(chks)){
			String[] chk =chks.split(",");
			List<DetectAttach> ids=new ArrayList<DetectAttach>();
			for(String s:chk){
				DetectAttach m=new DetectAttach();
				m.setId(s);
				ids.add(m);
			}
			detectAttachDao.deleteBatch(ids);
		}
	}
}
