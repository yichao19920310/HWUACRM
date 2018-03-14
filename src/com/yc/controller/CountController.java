package com.yc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.CountBiz;

@Controller
public class CountController {

	@Autowired
	private CountBiz countBiz;
	
	/**
	 * 
	  * @Title: countInfo   
	  * @Description: 统计员工销售信息  
	  * @param: followManId   
	  * @return: List<Map<String,Object>>      
	  * @throws
	 */
	@RequestMapping("countInfo")
	@ResponseBody
	public List<Map<String,Object>> countInfo(Integer followManId){
		
		return countBiz.countInfo(followManId);			
	}
	
	/**
	 * 
	  * @Title: countInfoForDepart   
	  * @Description: 统计部门销售信息   
	  * @param: departmentId      
	  * @return: List<Map<String,Object>>      
	  * @throws
	 */
	@RequestMapping("countInfoForDepart")
	@ResponseBody
	public List<Map<String,Object>> countInfoForDepart(Integer departmentId){
		
		return countBiz.countInfoForDepart(departmentId);
	}
	
	@RequestMapping("countConsult")
	@ResponseBody
	public List<Map<String,Object>> countConsult(Integer consultManId){
		
		return countBiz.countConsult(consultManId);
	}
	
	
	@RequestMapping("countConsultForDepart")
	@ResponseBody
	public List<Map<String,Object>> countConsultForDepart(Integer departmentId){
		
		return countBiz.countConsultForDepart(departmentId);
	}
}
