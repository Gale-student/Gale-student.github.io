package com.company.entity;

/**
 * 
 * mid: 管理员ID
 * mpwd: 管理员密码
 * mname: 管理员姓名
 * 
 * @author 86180
 *
 */

public class Manager {
	private String mid;
	private String mpwd;
	private String mname;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", mpwd=" + mpwd
				+ "]";
	}
	
	

}
