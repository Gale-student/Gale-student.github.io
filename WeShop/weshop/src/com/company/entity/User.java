package com.company.entity;

public class User {
	/**
	 * uid: �û��˺�
	 * upwd: �û�����
	 * uname: �û�����
	 * uaddress: �û���ַ
	 * ugender: �û��Ա�
	 * uage: �û�����
	 * uimage: �û�ͷ��
	 */
	private String uid;
	private String upwd;
	private String uname;
	private String uaddress;
	private String ugender;
	private String uage;
	private String utel;
	private String uimage;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUage() {
		return uage;
	}

	public void setUage(String uage) {
		this.uage = uage;
	}

	public String getUimage() {
		return uimage;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	@Override
	public String toString() {
		return "User [uaddress=" + uaddress + ", uage=" + uage + ", ugender="
				+ ugender + ", uid=" + uid + ", uimage=" + uimage + ", uname="
				+ uname + ", upwd=" + upwd + ", utel=" + utel + "]";
	}
	
	
	

}
