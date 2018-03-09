package com.yc.biz;

import java.util.List;

import com.yc.bean.ConsultRecord;
import com.yc.bean.Custom;

public interface CustomDataBiz {

	List<Custom> getCustomList(Custom custom, Integer page, Integer rows);

	Integer getQueryCount(Custom custom);

	void updateCustom(Custom custom);

	boolean allotCustom();

	boolean allotToConsult(ConsultRecord consultRecord);

	boolean addCustom(Custom custom);

}
