package com.yc.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;
import com.yc.biz.ExcelBiz;
import com.yc.utils.ExcelUtil;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Controller
public class ExcelController {

	@Autowired
	private ExcelBiz excelBiz;
	
	@Autowired
	private ExcelUtil excelUtil;
	
	/**
	 * 
	  * @Title: exportCustom   
	  * @Description: 导出客户数据   
	  * @param: param
	  * @param: resp
	  * @throws IOException
	  * @throws RowsExceededException
	  * @throws WriteException
	  * @throws NoSuchMethodException
	  * @throws SecurityException
	  * @throws IllegalAccessException
	  * @throws IllegalArgumentException
	  * @throws InvocationTargetException      
	  * @return: void      
	 */
	@RequestMapping("exportCustom")
	public void exportCustom(@RequestParam Map<String,Object> param,HttpServletResponse resp) throws IOException, RowsExceededException, WriteException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Custom> list = excelBiz.exportCustom(param);
		ServletOutputStream sos = resp.getOutputStream();
		String filename = param.get("type1")==null?"本月客户数据.xls":"本周客户数据.xls";
		filename = URLEncoder.encode(filename, "UTF-8");
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		resp.setHeader("content-type", "application/x-xls");
		excelUtil.createExcel(list, sos);
	}
	
	/**
	 * 
	  * @Title: exportCustomInfo   
	  * @Description: 导出客户销售数据   
	  * @param: param
	  * @param: resp
	  * @throws IOException
	  * @throws RowsExceededException
	  * @throws WriteException
	  * @throws NoSuchMethodException
	  * @throws SecurityException
	  * @throws IllegalAccessException
	  * @throws IllegalArgumentException
	  * @throws InvocationTargetException      
	  * @return: void      
	 */
	@RequestMapping("exportCustomInfo")
	public void exportCustomInfo(@RequestParam Map<String,Object> param,HttpServletResponse resp) throws IOException, RowsExceededException, WriteException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<CustomInfo> list = excelBiz.exportCustomInfo(param);
		ServletOutputStream sos = resp.getOutputStream();
		String filename = param.get("type1")==null?"本月客户销售数据.xls":"本周客户销售数据.xls";
		filename = URLEncoder.encode(filename, "UTF-8");
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		resp.setHeader("content-type", "application/x-xls");
		excelUtil.createExcel(list, sos);
	}
	
	/**
	 * 
	  * @Title: exportConsultRecord   
	  * @Description: 导出客户咨询数据   
	  * @param: param
	  * @param: resp
	  * @throws IOException
	  * @throws RowsExceededException
	  * @throws WriteException
	  * @throws NoSuchMethodException
	  * @throws SecurityException
	  * @throws IllegalAccessException
	  * @throws IllegalArgumentException
	  * @throws InvocationTargetException      
	  * @return: void      
	 */
	@RequestMapping("exportConsultRecord")
	public void exportConsultRecord(@RequestParam Map<String,Object> param,HttpServletResponse resp) throws IOException, RowsExceededException, WriteException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<ConsultRecord> list = excelBiz.exportConsultRecord(param);
		ServletOutputStream sos = resp.getOutputStream();
		String filename = param.get("type1")==null?"本月客户咨询数据.xls":"本周客户咨询数据.xls";
		filename = URLEncoder.encode(filename, "UTF-8");
		resp.setHeader("content-disposition", "attachment;filename="+filename);
		resp.setHeader("content-type", "application/x-xls");
		excelUtil.createExcel(list, sos);
	}
	
	@RequestMapping("batchImportCustom")
	@ResponseBody
	public String batchImportCustom(@RequestParam MultipartFile file, HttpServletRequest request) throws IOException, BiffException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
		String realPath = request.getServletContext().getRealPath("/")+"excel/";
		String fileName = realPath+file.getOriginalFilename();
		File newFile = new File(fileName);
		newFile.createNewFile();//创建新文件
		//2.将本地文件的字节写入新文件
		file.transferTo(newFile);
		List<Custom> list = (List<Custom>) excelUtil.readExcel(newFile, Custom.class);
		Integer data = excelBiz.batchImportCustom(list);
		if(data==null) {
			return "false";
		}else {
			return data.toString();
		}					
	}
}
