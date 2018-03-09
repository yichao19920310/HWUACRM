package com.yc.bean;

public class Right {

	private Integer rid;
	private String rightName;
	private String rightType;
	private String url;
	private Integer pid;
	@Override
	public String toString() {
		return "Right [rid=" + rid + ", rightName=" + rightName + ", rightType=" + rightType + ", url=" + url + ", pid="
				+ pid + "]";
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getRightType() {
		return rightType;
	}
	public void setRightType(String rightType) {
		this.rightType = rightType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
