package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;
import com.yc.biz.ExcelBiz;
import com.yc.dao.ExcelDao;

@Service
public class ExcelBizImpl implements ExcelBiz {

	@Autowired
	private ExcelDao excelDao;

	@Override
	public List<Custom> exportCustom(Map<String, Object> param) {
		List<Custom> list = excelDao.exportCustom(param);
		for (Custom custom : list) {
			switch(custom.getCustomStatu()) {
			case "0":custom.setCustomStatu("新增未上门");
				break;
			case "1":custom.setCustomStatu("新增已上门");
				break;
			case "2":custom.setCustomStatu("销售跟进中");
				break;
			case "3":custom.setCustomStatu("咨询跟进中");
				break;
			case "4":custom.setCustomStatu("死单");
				break;
			case "5":custom.setCustomStatu("已报名");
				break;
			default:
				break;
			}
			switch(custom.getEducation()) {
			case "1":custom.setEducation("本科");
				break;
			case "2":custom.setEducation("专科");
				break;
			case "3":custom.setEducation("高中");
				break;
			case "4":custom.setEducation("硕士");
				break;
			default:
				break;
			}
			
		}
		return list;
	}

	@Override
	public List<CustomInfo> exportCustomInfo(Map<String, Object> param) {
		
		return excelDao.exportCustomInfo(param);
	}

	@Override
	public List<ConsultRecord> exportConsultRecord(Map<String, Object> param) {
		
		return excelDao.exportConsultRecord(param);
	}

	@Override
	public Integer batchImportCustom(List<Custom> list) {
		
		return excelDao.batchInsertCustom(list);
	}
}
