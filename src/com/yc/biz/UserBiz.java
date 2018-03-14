package com.yc.biz;

import java.util.List;

import com.yc.bean.Employee;
import com.yc.bean.ResetPass;
import com.yc.bean.Right;

public interface UserBiz {

	Employee login(Employee user);

	List<Right> getRights(Employee user);

	boolean updateUser(Employee user);

	boolean changePass(Integer employeeId, String pass, String newPass);

	boolean reqResetPass(ResetPass resetPass);

	List<Employee> queryConsulter();

	List<Employee> getEmpByJob(Integer jobInfoId);

	List<Employee> getEmpByDepart(Integer departmentId, Integer managerId);

}
