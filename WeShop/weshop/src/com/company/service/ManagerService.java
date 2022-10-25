package com.company.service;

import java.util.List;

import com.company.entity.Shop;
import com.company.entity.User;

public interface ManagerService {
	//管理员登录
	public String ManagerLogin(String mid, String mpwd) throws Exception;
	//获取管理员姓名
	public String getManagerName(String mid) throws Exception;
	//商品添加 
	public String addShop(String sid, String sname, String stype, String scount, String sprice, String simage) throws Exception;
	//删除商品
	public void removeShop(String sid) throws Exception;
	//修改商品价格
	public void modifyShopSprice(String sid, String sprice) throws Exception;
	//修改商品库存
	public void modifyShopScount(String sid, String scount) throws Exception;
	//修改商品图片
	public void modifyShopSimage(String sid, String simage) throws Exception;
	//查看单个商品
	public List<Shop> queryOneShop(String sid) throws Exception;
	//查看所有商品
	public List<Shop> queryAllShop() throws Exception;
	//分页
	public List<Shop> PagingQuery(int page) throws Exception;
	//获取行数
	public int AllRows() throws Exception;
	//商品库存减少(用户下单)
	public void modifyScount(String sid, String quantity) throws Exception;
	//商品库存增加(用户取消订单)
	public void modifyRebackScount(String sid, String quantity) throws Exception;
	//根据商品名查找商品
	public List<Shop> queryShopBySname(String sname, int page) throws Exception;
	//获取根据商品名查找商品的总行数
	public int queryShopBySnameRows(String sname) throws Exception;
	
}
