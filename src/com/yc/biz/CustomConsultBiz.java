package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.ConsultRecord;

public interface CustomConsultBiz {

	Integer getQueryCount(Map<String, Object> data);

	List<ConsultRecord> getConsultList(Map<String, Object> data);

	Integer updataRecord(ConsultRecord consultRecord);

	boolean addResult(ConsultRecord consultRecord);

}
