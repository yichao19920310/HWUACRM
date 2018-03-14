package com.yc.dao;

import java.util.List;
import java.util.Map;

import com.yc.bean.Department;
import com.yc.bean.Employee;
import com.yc.bean.JobInfo;
import com.yc.bean.ResetPass;

public interface AdminDao {

	Employee getUserByUsername(String username);

	List<Department> getDepartment();

	List<JobInfo> getJobByDid(Integer departmentId);

	Integer insertUser(Employee user);

	List<ResetPass> queryResetRequest();

	Integer resetPass(Map<String, Object> param);

	Integer deleteResetPass(Integer id);

	List<Employee> getAllEmp();

	Integer cancelUser(String username);

}
