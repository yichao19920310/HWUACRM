package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.ConsultRecord;

public interface CustomConsultDao {

	Integer queryCount(Map<String, Object> data);

	List<ConsultRecord> queryConsult(Map<String, Object> data);

	Integer updateRecord(ConsultRecord consultRecord);

	Integer addResult(ConsultRecord consultRecord);

}
