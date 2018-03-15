package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;

public interface ExcelBiz {

	List<Custom> exportCustom(Map<String, Object> param);

	List<CustomInfo> exportCustomInfo(Map<String, Object> param);

	List<ConsultRecord> exportConsultRecord(Map<String, Object> param);

	Integer batchImportCustom(List<Custom> list);

}
