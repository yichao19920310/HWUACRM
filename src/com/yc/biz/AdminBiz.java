package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Department;
import com.yc.bean.Employee;
import com.yc.bean.JobInfo;
import com.yc.bean.ResetPass;

public interface AdminBiz {

	boolean checkUsername(String username);

	List<Department> getDepartment();

	List<JobInfo> getJobByDid(Integer departmentId);

	boolean addUser(Employee user);

	List<ResetPass> queryResetRequest();

	boolean resetPass(Map<String,Object> param);

	List<Employee> getAllEmp();

	boolean cancelUser(String username);

	

}
