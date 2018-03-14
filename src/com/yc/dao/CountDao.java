package com.yc.dao;

import java.util.Map;

public interface CountDao {

	Map<String, Object> countInfo(Integer followManId);

	Map<String, Object> countInfoForDepart(Integer departmentId);

	Map<String, Object> countConsult(Integer consultManId);
	
	Map<String, Object> countConsultForDepart(Integer departmentId);

}
