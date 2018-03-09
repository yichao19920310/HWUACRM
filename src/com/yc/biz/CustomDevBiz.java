package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.CustomInfo;
import com.yc.bean.Employee;

public interface CustomDevBiz {

	Integer getQueryCount(Map<String, Object> param);

	List<CustomInfo> getCustomInfoList(Map<String, Object> param);

	Integer updateCustomInfo(CustomInfo customInfo);

	boolean addMark(CustomInfo customInfo);


}
