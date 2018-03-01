
package com.jy.controller.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jy.controller.base.BaseController;
import com.jy.common.utils.base.Const;
import com.jy.common.ajax.AjaxRes;
import com.jy.common.mybatis.Page;
import com.jy.entity.business.DetectAttach;

import com.jy.service.business.DetectAttachService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * <p>Title: DetectAttachController</p>
 * <p>Description: </p> 
 * <p>Company:www.baofenqi.com</p> 
 * @author larry
 * @version :1.0
 */
@Controller
@RequestMapping("/detectAttach")
public class DetectAttachController extends  BaseController<DetectAttach>{
	private static final Logger log = Logger.getLogger(DetectAttachController.class);
	@Autowired
	private DetectAttachService detectAttachService;
	
	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("permitBtn", getPermitBtn(Const.RESOURCES_TYPE_FUNCTION));
		return "business/detectAttach/list";
	}
	
	
	/**
	* <p>Description:分页查询信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes findByPage(Page<DetectAttach> page, DetectAttach detectAttach) {
		Map<String, Object> map = new HashMap<>();
		AjaxRes ar=getAjaxRes();
		try {
			page.setParam(detectAttach);
			Page<DetectAttach> detectAttachList = detectAttachService.findByPage(page);
			map.put("permitBtn",getPermitBtn(Const.RESOURCES_TYPE_BUTTON));
			map.put("list",detectAttachList);		
			ar.setSucceed(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	

	
	/**
	* <p>Description:查询集合信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="findList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes findList(DetectAttach detectAttach) {
		Map<String, Object> map = new HashMap<>();
		AjaxRes ar=getAjaxRes();
		try {
			List<DetectAttach> detectAttachList = detectAttachService.getDetectAttachsByParasNoPage(detectAttach);
			map.put("list",detectAttachList);		
			ar.setSucceed(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}
	

	/**
	* <p>Description:查询详情信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="findInfo",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes findInfo(DetectAttach detectAttach) {
		AjaxRes ar=getAjaxRes();
		try {
			detectAttach = detectAttachService.findInfo(detectAttach);
			ar.setSucceed(detectAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ar;
	}

	
	/**
	* <p>Description:新增信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="add",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public AjaxRes add(DetectAttach detectAttach){ 
		AjaxRes ar=getAjaxRes();
		try {
			Account account = (Account) getRequest().getSession().getAttribute(Const.SESSION_USER);
			detectAttachService.save(detectAttach);
			ar.setSucceedMsg(Const.SAVE_SUCCEED);
		} catch (Exception e) {
			logger.error(e.toString(),e);
			ar.setFailMsg(Const.SAVE_FAIL);
		}
		return ar;
	}  
	
	/**
	* <p>Description:修改信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes update(DetectAttach detectAttach){ 
		AjaxRes ar=getAjaxRes();
		try {
			Account account = (Account) getRequest().getSession().getAttribute(Const.SESSION_USER);
			detectAttachService.update(detectAttach);
			ar.setSucceedMsg(Const.UPDATE_SUCCEED);
		} catch (Exception e) {
			logger.error(e.toString(),e);
			ar.setFailMsg(Const.UPDATE_FAIL);
		}
		return ar;
	}  
	
	
	/**
	* <p>Description:删除信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delete(DetectAttach detectAttach){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_BUTTON))){
			try {
				detectAttachService.delete(detectAttach);
				ar.setSucceedMsg(Const.DEL_SUCCEED);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.DEL_FAIL);
			}
		}	
		return ar;
    }
	
	/**
	* <p>Description:批量删除信息 </p>
	* <p>Company:保分期 </p> 
	* @author larry 
	* @date 
	*/
	@RequestMapping(value="delBatch",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes delBatch(String chks){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_FUNCTION))){
			try {
				detectAttachService.deleteBatch(chks);
				ar.setSucceedMsg(Const.DEL_SUCCEED);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.DEL_FAIL);
			}
		}	
		return ar;
    }
}