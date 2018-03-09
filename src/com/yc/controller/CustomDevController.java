package com.yc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.CustomInfo;
import com.yc.bean.Employee;
import com.yc.biz.CustomDevBiz;
import com.yc.biz.UserBiz;

@Controller
public class CustomDevController {

	private static final String SUCCESS="1";
	private static final String FAILED="0";
	
	@Autowired
	private CustomDevBiz customDevBiz;
	
	@Autowired
	private UserBiz userBiz;
	
	/**
	 * 
	  * @Title: customInfo   
	  * @Description: 获取客户销售信息列表   
	  * @param: param     
	  * @return: Map<String,Object>      
	  * @throws
	 */
	@RequestMapping("customInfo")
	@ResponseBody
	public Map<String,Object> customInfo(@RequestParam Map<String,Object> param){
		param.put("page", Integer.parseInt(param.get("page").toString()));
		param.put("rows", Integer.parseInt(param.get("rows").toString()));
		param.put("src", Integer.parseInt(param.get("src").toString()));
		System.out.println(param);
		Integer total = customDevBiz.getQueryCount(param);
		List<CustomInfo> list = customDevBiz.getCustomInfoList(param);
		Map<String,Object> data = new HashMap<>();
		data.put("total", total);
		data.put("rows", list);
		return data;
		
	}
	
	@RequestMapping("updateCustomInfo")
	@ResponseBody
	public void updateCustomInfo(CustomInfo customInfo) {
		customDevBiz.updateCustomInfo(customInfo);
	}
	
	@RequestMapping("addMark")
	@ResponseBody
	public String addMark(CustomInfo customInfo) {
		return customDevBiz.addMark(customInfo)?SUCCESS:FAILED;
	}
	
}
