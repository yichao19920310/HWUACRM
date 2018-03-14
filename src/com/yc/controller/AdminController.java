package com.yc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Department;
import com.yc.bean.Employee;
import com.yc.bean.JobInfo;
import com.yc.bean.ResetPass;
import com.yc.biz.AdminBiz;

@Controller
public class AdminController {

	private static final String SUCCESS="1";
	private static final String FAILED="0";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	@Autowired
	private AdminBiz adminBiz;
	
	/**
	 * 
	  * @Title: checkUsername   
	  * @Description: 检查用户名是否可用   
	  * @param: username    
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("checkUsername")
	@ResponseBody
	public String checkUsername(String username) {
		
		//TRUE代表用户名可以使用
		return adminBiz.checkUsername(username)?TRUE:FALSE;
	}
	
	/**
	 * 
	  * @Title: getDepartment   
	  * @Description: 获取部门列表用于添加普通员工        
	  * @return: List<Department>      
	  * @throws
	 */
	@RequestMapping("getDepartment")
	@ResponseBody
	public List<Department> getDepartment(){
		
		return adminBiz.getDepartment();
	}
	
	/**
	 * 
	  * @Title: getJobByDid   
	  * @Description: 获取对应部门的职位列表用于添加普通员工   
	  * @param: departmentId     
	  * @return: List<JobInfo>      
	  * @throws
	 */
	@RequestMapping("getJobByDid")
	@ResponseBody
	public List<JobInfo> getJobByDid(Integer departmentId){
		
		return adminBiz.getJobByDid(departmentId);
	}
	
	/**
	 * 
	  * @Title: addUser   
	  * @Description: 添加员工账户   
	  * @param: user    
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(Employee user) {
		
		return adminBiz.addUser(user)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: queryResetRequest   
	  * @Description: 获取重置密码申请列表        
	  * @return: List<ResetPass>      
	  * @throws
	 */
	@RequestMapping("querRestRequest")
	@ResponseBody
	public List<ResetPass> queryResetRequest(){
		
		return adminBiz.queryResetRequest();
	}
	
	/**
	 * 
	  * @Title: resetPass   
	  * @Description: 重置密码   
	  * @param: @return      
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("resetPass")
	@ResponseBody
	public String resetPass(@RequestParam Map<String,Object> param) {
		
		return adminBiz.resetPass(param)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: allEmployees   
	  * @Description: 获取所有在职员工集合         
	  * @return: List<Employee>      
	  * @throws
	 */
	@RequestMapping("allEmployees")
	@ResponseBody
	public List<Employee> allEmployees(){
		
		return adminBiz.getAllEmp();
	}
	
	@RequestMapping("cancleUser")
	@ResponseBody
	public String cancelUser(String username) {
		
		return adminBiz.cancelUser(username)?SUCCESS:FAILED;
	}
}
