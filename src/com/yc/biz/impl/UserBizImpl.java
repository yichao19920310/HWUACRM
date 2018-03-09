package com.yc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Employee;
import com.yc.bean.ResetPass;
import com.yc.bean.Right;
import com.yc.biz.UserBiz;
import com.yc.dao.UserDao;

@Service
@Transactional
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Employee login(Employee user) {
		
		return userDao.getUserByNameAndPass(user);
	}

	@Override
	public List<Right> getRights(Employee user) {
		
		return userDao.getRightsByUser(user);
	}

	@Override
	public boolean updateUser(Employee user) {
		
		return userDao.updateUser(user)==1;
	}

	@Override
	public boolean changePass(Integer employeeId, String pass, String newPass) {
		
		return userDao.updatePass(employeeId,pass,newPass)==1;
	}

	@Override
	public boolean reqResetPass(ResetPass resetPass) {
		
		return userDao.insertResetPass(resetPass)==1;
	}

	@Override
	public List<Employee> queryConsulter() {
		
		return userDao.getEmpByJobId(3);
	}

	@Override
	public List<Employee> getEmpByJob(Integer jobInfoId) {
		
		return userDao.getEmpByJobId(jobInfoId);
	}

}
