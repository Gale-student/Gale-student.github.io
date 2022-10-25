package com.company.entity;

/**
 * 
 * sid: 商品ID
 * sname: 商品名
 * stype: 商品类型
 * scount: 商品库存
 * sprice: 商品单价
 * simage: 商品图片
 * 
 ** @author 86180
 *
 */

public class Shop {
	private String sid;
	private String sname;
	private String stype;
	private String scount;
	private String sprice;
	private String simage;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getScount() {
		return scount;
	}
	public void setScount(String scount) {
		this.scount = scount;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}
	@Override
	public String toString() {
		return "Shop [scount=" + scount + ", sid=" + sid + ", simage=" + simage
				+ ", sname=" + sname + ", sprice=" + sprice + ", stype="
				+ stype + "]";
	}
	

}
