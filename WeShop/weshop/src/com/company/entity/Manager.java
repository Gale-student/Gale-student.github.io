package com.company.entity;

/**
 * 
 * mid: ����ԱID
 * mpwd: ����Ա����
 * mname: ����Ա����
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
