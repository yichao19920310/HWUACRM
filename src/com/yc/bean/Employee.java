package com.yc.bean;

public class Employee {

	private Integer id;
	private String username;
	private String pass;
	private String nickname;
	private String realname;
	private Integer jobInfoId;
	private String job;
	private Integer departmentId;
	private String dname;
	private String phoneNo;
	private String officeTel;
	private String workStatu;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", pass=" + pass + ", nickname=" + nickname
				+ ", realname=" + realname + ", jobInfoId=" + jobInfoId + ", job=" + job + ", departmentId="
				+ departmentId + ", dname=" + dname + ", phoneNo=" + phoneNo + ", officeTel=" + officeTel
				+ ", workStatu=" + workStatu + "]";
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getJobInfoId() {
		return jobInfoId;
	}
	public void setJobInfoId(Integer jobInfoId) {
		this.jobInfoId = jobInfoId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getWorkStatu() {
		return workStatu;
	}
	public void setWorkStatu(String workStatu) {
		this.workStatu = workStatu;
	}
	
}
