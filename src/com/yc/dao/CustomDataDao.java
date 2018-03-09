package com.yc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;
import com.yc.bean.CustomInfo;

public interface CustomDataDao {

	List<Custom> queryCustom(Map<String,Object> data);

	Integer queryCount(Custom custom);

	Integer updateCustom(Custom custom);

	Integer insertCustomInfo(List<CustomInfo> customInfoList);

	List<Custom> getUnallotedCustom();

	Integer updateCustomStatuWhenAllot(Map<String,Object> data);

	Integer insertConsultRecord(ConsultRecord consultRecord);

	Integer insertCustom(Custom custom);

	Integer updateCustomStatuWhenDead(Integer customId);

}
