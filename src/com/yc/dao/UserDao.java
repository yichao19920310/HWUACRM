package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.bean.Employee;
import com.yc.bean.ResetPass;
import com.yc.bean.Right;

public interface UserDao {

	Employee getUserByNameAndPass(Employee user);

	List<Right> getRightsByUser(Employee user);

	int updateUser(Employee user);

	int updatePass(@Param("id") Integer employeeId,@Param("pass") String pass,@Param("newPass") String newPass);

	int insertResetPass(ResetPass resetPass);

	List<Employee> getEmpByJobId(Integer jobInfoId);

	List<Employee> getEmpByDepartId(@Param("departmentId") Integer departmentId,@Param("managerId") Integer managerId);
	
	List<Employee> getFollowMan();
}
