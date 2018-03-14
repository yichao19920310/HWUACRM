package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.Department;
import com.yc.bean.Employee;
import com.yc.bean.JobInfo;
import com.yc.bean.ResetPass;
import com.yc.biz.AdminBiz;
import com.yc.dao.AdminDao;

@Service
public class AdminBizImpl implements AdminBiz {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean checkUsername(String username) {
		//不存在返回true 存在返回false
		return adminDao.getUserByUsername(username)==null;
	}

	@Override
	public List<Department> getDepartment() {
		
		return adminDao.getDepartment();
	}

	@Override
	public List<JobInfo> getJobByDid(Integer departmentId) {
		
		return adminDao.getJobByDid(departmentId);
	}

	@Override
	public boolean addUser(Employee user) {
		
		return adminDao.insertUser(user)==1;
	}

	@Override
	public List<ResetPass> queryResetRequest() {
		
		return adminDao.queryResetRequest();
	}

	@Override
	public boolean resetPass(Map<String, Object> param) {
		
		int rInt = 0;
		rInt += adminDao.resetPass(param);
		rInt += adminDao.deleteResetPass(Integer.parseInt(param.get("id").toString()));
		return rInt==2;
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return adminDao.getAllEmp();
	}

	@Override
	public boolean cancelUser(String username) {
		
		return adminDao.cancelUser(username)==1;
	}
}
