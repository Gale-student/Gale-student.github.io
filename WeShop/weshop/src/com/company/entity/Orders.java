package com.company.entity;
/**
 * oid: 订单号
 * uid: 用户ID
 * sid: 商品ID
 * quantity: 购买数量
 * date: 下单日期
 * status: 支付状态
 * 
 * @author 86180
 *
 */

public class Orders {
	private String oid;
	private String uid;
	private String sid;
	private String quantity;
	private String date;
	private String status;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Orders [date=" + date + ", oid=" + oid + ", quantity="
				+ quantity + ", sid=" + sid + ", status=" + status + ", uid="
				+ uid + "]";
	}
	

}
