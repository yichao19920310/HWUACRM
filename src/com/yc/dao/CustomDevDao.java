package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.CustomInfo;

public interface CustomDevDao {

	Integer queryCount(Map<String, Object> param);

	List<CustomInfo> queryCustomInfo(Map<String, Object> param);

	Integer updateCustomInfo(CustomInfo customInfo);

	Integer addMark(CustomInfo customInfo);

}
