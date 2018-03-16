package com.yc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.biz.CustomConsultBiz;

@Controller
public class CustomConsultController {

	@Autowired
	private CustomConsultBiz customConsultBiz;
	
	private static final String SUCCESS="1";
	private static final String FAILED="0";
	/**
	 * 
	  * @Title: queryRecord   
	  * @Description: 获取咨询记录表   
	  * @param: data      
	  * @return: Map<String,Object>      
	  * @throws
	 */
	@RequestMapping("queryRecord")
	@ResponseBody
	public Map<String,Object> queryRecord(@RequestParam Map<String,Object> data){
		System.out.println(data);
		data.put("page",Integer.parseInt(data.get("page").toString()));
		data.put("rows",Integer.parseInt(data.get("rows").toString()));
		Integer total = customConsultBiz.getQueryCount(data);
		List<ConsultRecord> list = customConsultBiz.getConsultList(data);
		Map<String,Object> outData = new HashMap<>();
		outData.put("rows", list);
		outData.put("total", total);
		return outData;
	}
	
	/**
	 * 
	  * @Title: updateRecord   
	  * @Description: 修改咨询记录状态   
	  * @param: consultRecord      
	  * @return: void      
	  * @throws
	 */
	@RequestMapping("updateRecord")
	@ResponseBody
	public void updateRecord(ConsultRecord consultRecord) {
		customConsultBiz.updataRecord(consultRecord);
	}
	
	/**
	 * 
	  * @Title: addResult   
	  * @Description: 添加咨询记录备注   
	  * @param: consultRecord      
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("addResult")
	@ResponseBody
	public String addResult(ConsultRecord consultRecord)  {
		return customConsultBiz.addResult(consultRecord)?SUCCESS:FAILED;
	}
}
