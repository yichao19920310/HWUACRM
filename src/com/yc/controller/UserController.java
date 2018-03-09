package com.yc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Employee;
import com.yc.bean.ResetPass;
import com.yc.bean.Right;
import com.yc.biz.UserBiz;

@Controller
public class UserController {

	private static final String SUCCESS="1";
	private static final String FAILED="0";
	@Autowired
	private UserBiz userBiz;
	
	/**
	 * 
	  * @Title: login   
	  * @Description: 用户登录   
	  * @param: user
	  * @param: session    
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("login")
	@ResponseBody
	public String login(Employee user,HttpSession session) {
		
		user = userBiz.login(user);
		//System.out.println(user);
		if(user!=null) {
			List<Right> rights = userBiz.getRights(user);
			//System.out.println(rights);
			session.setAttribute("user", user);
			session.setAttribute("rights", rights);
		}
		return user!=null?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: logout   
	  * @Description: 用户注销   
	  * @param: @param session
	  * @param: @return      
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.jsp";
	}
	
	/**
	 * 
	  * @Title: updateUser   
	  * @Description: 更改个人信息   
	  * @param: @param user
	  * @param: @return      
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(Employee user) {
		//System.out.println(user);
		
		return userBiz.updateUser(user)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: changePass   
	  * @Description: 修改密码   
	  * @param: employeeId
	  * @param: pass
	  * @param: newPass    
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("changePass")
	@ResponseBody
	public String changePass(Integer employeeId,String pass,String newPass) {
		System.out.println(employeeId+":"+pass+":"+newPass);
		
		return userBiz.changePass(employeeId,pass,newPass)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: reqResetPass   
	  * @Description: 申请重置密码   
	  * @param: username
	  * @param: phoneNo    
	  * @return: String      
	  * @throws
	 */
	@RequestMapping("reqResetPass")
	@ResponseBody
	public String reqResetPass(ResetPass resetPass) {
		
		return userBiz.reqResetPass(resetPass)?SUCCESS:FAILED;
	}
	
	/**
	 * 
	  * @Title: queryConsulters   
	  * @Description: 获取线下咨询师列表        
	  * @return: List<Employee>      
	  * @throws
	 */
	@RequestMapping("queryConsulters")
	@ResponseBody
	public List<Employee> queryConsulters(){
		
		return userBiz.queryConsulter();
	}
	
	/**
	 * 
	  * @Title: empForJobId   
	  * @Description: 根据职业获取员工列表   
	  * @param: jobInfoId    
	  * @return: List<Employee>      
	  * @throws
	 */
	@RequestMapping("empForJobId")
	@ResponseBody
	public List<Employee> empForJobId(Integer jobInfoId){
		
		return userBiz.getEmpByJob(jobInfoId);
	}
	
	
}
