package com.yc.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ConsultRecord {

	private Integer id;
	private Integer customId;
	private Integer consultManId;
	private String customName;
	private String customPhoneNo;
	private String consultStatu;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+08:00")
	private Date consultDate;
	private String result;
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
	public Integer getConsultManId() {
		return consultManId;
	}
	public void setConsultManId(Integer consultManId) {
		this.consultManId = consultManId;
	}
	public String getConsultStatu() {
		return consultStatu;
	}
	public void setConsultStatu(String consultStatu) {
		this.consultStatu = consultStatu;
	}
	public Date getConsultDate() {
		return consultDate;
	}
	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
		return "ConsultRecord [id=" + id + ", customId=" + customId + ", consultManId=" + consultManId + ", customName="
				+ customName + ", customPhoneNo=" + customPhoneNo + ", consultStatu=" + consultStatu + ", consultDate="
				+ consultDate + ", result=" + result + "]";
	}
	
	
}
