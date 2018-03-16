package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.ConsultRecord;
import com.yc.biz.CustomConsultBiz;
import com.yc.dao.CustomConsultDao;
import com.yc.dao.CustomDataDao;

@Service
@Transactional
public class CustomConsultBizImpl implements CustomConsultBiz {

	@Autowired
	private CustomConsultDao customConsultDao;
	
	@Autowired
	private CustomDataDao customDataDao;
	
	@Override
	public Integer getQueryCount(Map<String, Object> data) {
		
		return customConsultDao.queryCount(data);
	}

	@Override
	public List<ConsultRecord> getConsultList(Map<String, Object> data) {
		
		return customConsultDao.queryConsult(data);
	}

	@Override
	public Integer updataRecord(ConsultRecord consultRecord) {
		Integer rInt = 0;
		rInt += customConsultDao.updateRecord(consultRecord);
		if("3".equals(consultRecord.getConsultStatu())&&rInt==1) {
			rInt += customDataDao.updateCustomStatuWhenDead(consultRecord.getCustomId());
		}else if("2".equals(consultRecord.getConsultStatu())&&rInt==1) {
			rInt += customDataDao.updateCustomStatu(consultRecord.getCustomId(), "5");
		}
		return rInt;
	}

	@Override
	public boolean addResult(ConsultRecord consultRecord) {
		return customConsultDao.addResult(consultRecord)==1;
	}

}
