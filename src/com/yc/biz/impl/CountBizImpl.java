package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.biz.CountBiz;
import com.yc.dao.CountDao;

@Service
public class CountBizImpl implements CountBiz {

	@Autowired
	private CountDao countDao;

	@Override
	public List<Map<String, Object>> countInfo(Integer followManId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(countDao.countInfo(followManId));
		return list;
	}

	@Override
	public List<Map<String, Object>> countInfoForDepart(Integer departmentId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(countDao.countInfoForDepart(departmentId));
		return list;
	}

	@Override
	public List<Map<String, Object>> countConsult(Integer consultManId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(countDao.countConsult(consultManId));
		return list;
	}

	@Override
	public List<Map<String, Object>> countConsultForDepart(Integer departmentId) {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(countDao.countConsultForDepart(departmentId));
		return list;
	}
}
