package com.yc.biz;

import java.util.List;
import java.util.Map;

public interface CountBiz {

	List<Map<String, Object>> countInfo(Integer followManId);

	List<Map<String, Object>> countInfoForDepart(Integer departmentId);

	List<Map<String, Object>> countConsult(Integer consultManId);

	List<Map<String, Object>> countConsultForDepart(Integer departmentId);

}
