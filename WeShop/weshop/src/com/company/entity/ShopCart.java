package com.company.entity;
/**
 * sid: ��Ʒ��Ϣ(sid, sname, stype, sprice, scount, simage)
 * uid: �û�ID
 * shopQuantity: ��Ʒ��������
 * 
 * @author 86180
 *
 */

public class ShopCart {
	private String sid;
	private String uid;
	private String shopQuantity;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getShopQuantity() {
		return shopQuantity;
	}
	public void setShopQuantity(String shopQuantity) {
		this.shopQuantity = shopQuantity;
	}
	@Override
	public String toString() {
		return "ShopCart [sid=" + sid + ", shopQuantity=" 
		        + shopQuantity + "" +", uid=" + uid + "]";
	}
	
	

}
