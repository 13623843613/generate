<#assign className = table.className>
        <#assign classNameFirstLower = className?uncap_first>
        <#assign classNameLowerCase = className?lower_case>
        <#assign pkJavaType = table.idColumn.javaType>
package ${basepackage}.controller.business;
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
import ${basepackage}.entity.business.${className};

import ${basepackage}.service.business.${className}Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaotian
 * @create 2018-03-02 上午10:24
 */
@Controller
@RequestMapping("/${classNameFirstLower}")
public class ${className}Controller extends BaseController<${className}>{
private static final Logger log=Logger.getLogger(${className}Controller.class);
@Autowired
private ${className}Service ${classNameFirstLower}Service;

@RequestMapping("index")
public String index(Model model){
        model.addAttribute("permitBtn",getPermitBtn(Const.RESOURCES_TYPE_FUNCTION));
        return"business/${classNameFirstLower}/list";
        }


/**
 * Description:分页查询信息
 *
 * @date
 */
@RequestMapping(value = "findByPage", method = RequestMethod.POST)
@ResponseBody
public AjaxRes findByPage(Page<${className}>page,${className}${classNameFirstLower}){
        Map<String, Object> map=new HashMap<>();
        AjaxRes ar=getAjaxRes();
        try{
        page.setParam(${classNameFirstLower});
        Page<${className}>${classNameFirstLower}List=${classNameFirstLower}Service.findByPage(page);
        map.put("permitBtn",getPermitBtn(Const.RESOURCES_TYPE_BUTTON));
        map.put("list",${classNameFirstLower}List);
        ar.setSucceed(map);
        }catch(Exception e){
        e.printStackTrace();
        }
        return ar;
        }


/**
 * Description:查询集合信息
 *
 * @date
 */
@RequestMapping(value = "findList", method = RequestMethod.POST)
@ResponseBody
public AjaxRes findList(${className}${classNameFirstLower}){
        Map<String, Object> map=new HashMap<>();
        AjaxRes ar=getAjaxRes();
        try{
        List<${className}>${classNameFirstLower}List=${classNameFirstLower}Service.get${className}sByParasNoPage(${classNameFirstLower});
        map.put("list",${classNameFirstLower}List);
        ar.setSucceed(map);
        }catch(Exception e){
        e.printStackTrace();
        }
        return ar;
        }


/**
 * Description:查询详情信息
 * @date
 */
@RequestMapping(value = "findInfo", method = RequestMethod.POST)
@ResponseBody
public AjaxRes findInfo(${className}${classNameFirstLower}){
        AjaxRes ar=getAjaxRes();
        try{
        ${classNameFirstLower}=${classNameFirstLower}Service.findInfo(${classNameFirstLower});
        ar.setSucceed(${classNameFirstLower});
        }catch(Exception e){
        e.printStackTrace();
        }
        return ar;
        }


/**
 * Description:新增信息
 * @date
 */
@RequestMapping(value = "add", method = {RequestMethod.POST, RequestMethod.GET})
@ResponseBody
public AjaxRes add(${className}${classNameFirstLower}){
        AjaxRes ar=getAjaxRes();
        try{
        Account account=(Account)getRequest().getSession().getAttribute(Const.SESSION_USER);
        ${classNameFirstLower}Service.save(${classNameFirstLower});
        ar.setSucceedMsg(Const.SAVE_SUCCEED);
        }catch(Exception e){
        logger.error(e.toString(),e);
        ar.setFailMsg(Const.SAVE_FAIL);
        }
        return ar;
        }

/**
 * Description:修改信息
 * @date
 */
@RequestMapping(value = "update", method = RequestMethod.POST)
@ResponseBody
public AjaxRes update(${className}${classNameFirstLower}){
        AjaxRes ar=getAjaxRes();
        try{
        Account account=(Account)getRequest().getSession().getAttribute(Const.SESSION_USER);
        ${classNameFirstLower}Service.update(${classNameFirstLower});
        ar.setSucceedMsg(Const.UPDATE_SUCCEED);
        }catch(Exception e){
        logger.error(e.toString(),e);
        ar.setFailMsg(Const.UPDATE_FAIL);
        }
        return ar;
        }


/**
 * Description:删除信息
 * @date
 */
@RequestMapping(value = "delete", method = RequestMethod.POST)
@ResponseBody
public AjaxRes delete(${className}${classNameFirstLower}){
        AjaxRes ar=getAjaxRes();
        if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_BUTTON))){
        try{
        ${classNameFirstLower}Service.delete(${classNameFirstLower});
        ar.setSucceedMsg(Const.DEL_SUCCEED);
        }catch(Exception e){
        logger.error(e.toString(),e);
        ar.setFailMsg(Const.DEL_FAIL);
        }
        }
        return ar;
        }

/**
 * Description:批量删除信息
 * @date
 */
@RequestMapping(value = "delBatch", method = RequestMethod.POST)
@ResponseBody
public AjaxRes delBatch(String chks){
        AjaxRes ar=getAjaxRes();
        if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_FUNCTION))){
        try{
        ${classNameFirstLower}Service.deleteBatch(chks);
        ar.setSucceedMsg(Const.DEL_SUCCEED);
        }catch(Exception e){
        logger.error(e.toString(),e);
        ar.setFailMsg(Const.DEL_FAIL);
        }
        }
        return ar;
        }
        }