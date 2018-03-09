package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;
import com.yc.bean.Employee;
import com.yc.biz.CustomDataBiz;
import com.yc.dao.CustomDataDao;
import com.yc.dao.UserDao;

@Service
@Transactional
public class CustomDataBizImpl implements CustomDataBiz {

	@Autowired
	private CustomDataDao customDataDao;

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Custom> getCustomList(Custom custom,Integer page,Integer rows) {
		Map<String,Object> data = new HashMap<>();
		data.put("name", custom.getName());
		data.put("customStatu", custom.getCustomStatu());
		data.put("inviteName", custom.getInviteName());
		data.put("phoneNo", custom.getPhoneNo());
		data.put("createDate", custom.getCreateDate());
		data.put("page", page);
		data.put("rows", rows);
		return customDataDao.queryCustom(data);
	}

	@Override
	public Integer getQueryCount(Custom custom) {
		
		return customDataDao.queryCount(custom);
	}

	@Override
	public void updateCustom(Custom custom) {
		
		customDataDao.updateCustom(custom);
		
	}

	@Override
	public boolean allotCustom() {
		
		List<Custom> customList = customDataDao.getUnallotedCustom();
		List<Employee> followManList = userDao.getEmpByJobId(8);
		List<CustomInfo> customInfoList = new ArrayList<>();
		int cuCount = customList.size();
		int fmCount = followManList.size();
		if(cuCount==0||fmCount==0) {
			return false;
		}
		for (int i = 0; i < cuCount/fmCount+1; i++) {
			for (int j = 0; j < fmCount; j++) {
				int customIndex = i*fmCount+j;
				if(customIndex<cuCount) {
					CustomInfo ci = new CustomInfo();
					ci.setCustomId(customList.get(customIndex).getId());
					ci.setFollowManId(followManList.get(j).getId());
					ci.setStatu("0");
					customInfoList.add(ci);
				}else {
					break;
				}
			}
		}
		Map<String,Object> data = new HashMap<>();
		data.put("list", customList);
		data.put("customStatu", "2");

		int rInt1 = customDataDao.insertCustomInfo(customInfoList);
		int rInt2 = customDataDao.updateCustomStatuWhenAllot(data);
		return rInt1 == cuCount && rInt2 == cuCount;
	}

	@Override
	public boolean allotToConsult(ConsultRecord consultRecord) {
		int rInt = 0;
		rInt += customDataDao.insertConsultRecord(consultRecord);
		Map<String,Object> data = new HashMap<>();
		List<Custom> list = new ArrayList<>();
		Custom custom = new Custom();
		custom.setId(consultRecord.getCustomId());
		list.add(custom);
		data.put("list", list);
		data.put("customStatu", "3");
		rInt += customDataDao.updateCustomStatuWhenAllot(data);
		return rInt==2;
	}

	@Override
	public boolean addCustom(Custom custom) {
		
		return customDataDao.insertCustom(custom)==1;
	}
}
