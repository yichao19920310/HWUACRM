package com.yc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.biz.CustomDataBiz;

@Controller
public class CustomDataController {

	private static final String SUCCESS="1";
	private static final String FAILED="0";
	
	@Autowired
	private CustomDataBiz customDataBiz;
	
	/**
	 * 
	  * @Title: queryCustom   
	  * @Description: 获取客户列表
	  * @param: custom
	  * @param: page 当前页数
	  * @param: rows 每页行数    
	  * @return: Map<String,Object>      
	  * @throws
	 */
	@RequestMapping("queryCustom")
	@ResponseBody
	public Map<String,Object> queryCustom(Custom custom,Integer page,Integer rows){
		System.out.println(custom);
		Integer total = customDataBiz.getQueryCount(custom);
		List<Custom> customList = customDataBiz.getCustomList(custom,page,rows);
		Map<String,Object> data = new HashMap<>();
		data.put("rows", customList);
		data.put("total", total);
		return data;
	}
	
	/**
	 * 
	  * @Title: updateCustom   
	  * @Description: 修改客户信息 
	  * @param: custom      
	  * @return: void      
	  * @throws
	 */
	@RequestMapping("updateCustom")
	@ResponseBody
	public void updateCustom(Custom custom) {
		System.out.println(custom);
		customDataBiz.updateCustom(custom);
	}
	
	/**
	 * 
	  * @Title: allotCustom   
	  * @Description: 自动分配新增未上门客户        
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("allotCustom")
	@ResponseBody
	public String allotCustom() {
		
		return customDataBiz.allotCustom()?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: allotToConsult   
	  * @Description: 分配客户给线下咨询师   
	  * @param: consultRecord     
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("allotToConsult")
	@ResponseBody
	public String allotToConsult(ConsultRecord consultRecord) {
		System.out.println(consultRecord);
		return customDataBiz.allotToConsult(consultRecord)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: insertCustom   
	  * @Description: 新增客户   
	  * @param: custom     
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("insertCustom")
	@ResponseBody
	public String insertCustom(Custom custom) {
		System.out.println(custom);
		return customDataBiz.addCustom(custom)?SUCCESS:FAILED;
	}
}
