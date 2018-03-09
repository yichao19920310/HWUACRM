package com.yc.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomInfo {

	private Integer id;
	private Integer customId;
	private String customName;
	private String customPhoneNo;
	private Integer followManId;
	private String statu;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+08:00")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+08:00")
	private Date lastFollowDate;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+08:00")
	private Date planDate;
	private String mark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomId() {
		return customId;
	}
	public void setCustomId(Integer customId) {
		this.customId = customId;
	}
	public Integer getFollowManId() {
		return followManId;
	}
	public void setFollowManId(Integer followManId) {
		this.followManId = followManId;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getLastFollowDate() {
		return lastFollowDate;
	}
	public void setLastFollowDate(Date lastFollowDate) {
		this.lastFollowDate = lastFollowDate;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomPhoneNo() {
		return customPhoneNo;
	}
	public void setCustomPhoneNo(String customPhoneNo) {
		this.customPhoneNo = customPhoneNo;
	}
	@Override
	public String toString() {
		return "CustomInfo [id=" + id + ", customId=" + customId + ", customName=" + customName + ", customPhoneNo="
				+ customPhoneNo + ", followManId=" + followManId + ", statu=" + statu + ", startDate=" + startDate
				+ ", lastFollowDate=" + lastFollowDate + ", planDate=" + planDate + ", mark=" + mark + "]";
	}
	
	
}
