package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.CustomInfo;
import com.yc.biz.CustomDevBiz;
import com.yc.dao.CustomDataDao;
import com.yc.dao.CustomDevDao;

@Service
public class CustomDevBizImpl implements CustomDevBiz {

	@Autowired
	private CustomDevDao customDevDao;
	
	@Autowired
	private CustomDataDao customDataDao;

	@Override
	public Integer getQueryCount(Map<String, Object> param) {
		
		return customDevDao.queryCount(param);
	}

	@Override
	public List<CustomInfo> getCustomInfoList(Map<String, Object> param) {
		
		return customDevDao.queryCustomInfo(param);
	}

	@Override
	public Integer updateCustomInfo(CustomInfo customInfo) {
		Integer rInt = 0;
		rInt += customDevDao.updateCustomInfo(customInfo);
		if("4".equals(customInfo.getStatu())&&rInt==1) {
			rInt += customDataDao.updateCustomStatuWhenDead(customInfo.getCustomId());
		}else if("3".equals(customInfo.getStatu())&&rInt==1){
			rInt += customDataDao.updateCustomStatu(customInfo.getCustomId(),"1");
		}
		return rInt;
	}

	@Override
	public boolean addMark(CustomInfo customInfo) {
		
		return customDevDao.addMark(customInfo)==1;
	}

	
}
