package com.company.entity;
/**
 * 
 * sid: ��ƷID
 * sname: ��Ʒ��
 * stype: ��Ʒ����
 * sprice: ��Ʒ����
 * shopQuantity: ��Ʒ����
 * shopPrice: ������Ʒ���ܼ�
 * 
 * @author 86180
 *
 */

public class ShopCartDetail {
    private String sid;
    private String sname;
    private String stype;
    private String sprice;
    private String shopQuantity;
    private String shopPrice;
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
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getShopQuantity() {
		return shopQuantity;
	}
	public void setShopQuantity(String shopQuantity) {
		this.shopQuantity = shopQuantity;
	}
	public String getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(String shopPrice) {
		this.shopPrice = shopPrice;
	}
	@Override
	public String toString() {
		return "ShopCartDetail [shopPrice=" + shopPrice + ", shopQuantity="
				+ shopQuantity + ", sid=" + sid + ", sname=" + sname
				+ ", sprice=" + sprice + ", stype=" + stype + "]";
	}
    
    
}
