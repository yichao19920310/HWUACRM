package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;

public interface ExcelDao {

	List<Custom> exportCustom(Map<String, Object> param);

	List<CustomInfo> exportCustomInfo(Map<String, Object> param);

	List<ConsultRecord> exportConsultRecord(Map<String, Object> param);

	Integer batchInsertCustom(List<Custom> list);

}
