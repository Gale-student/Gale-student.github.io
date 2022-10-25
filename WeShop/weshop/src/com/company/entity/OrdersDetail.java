package com.company.entity;
/**
 * oid: 订单号
 * uid: 用户ID
 * sname: 商品名
 * sprice: 商品单价
 * quantity: 购买数量
 * shopPrice: 单个商品的总价
 * date: 下单日期
 * status: 订单状态
 * 
 * @author 86180
 *
 */

public class OrdersDetail {
	private String oid;
	private String uid;
	private String sname;
	private String sprice;
	private String quantity;
	private String shopPrice ;
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getShopPrice () {
		return shopPrice ;
	}
	public void setShopPrice (String shopPrice ) {
		this.shopPrice  = shopPrice ;
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
		return "OrdersDetail [date=" + date + ", oid=" + oid + ", quantity="
				+ quantity + ", sname=" + sname + ", sprice=" + sprice
				+ ", status=" + status + ", shopPrice =" + shopPrice 
				+ ", uid=" + uid + "]";
	}
	
	
}
