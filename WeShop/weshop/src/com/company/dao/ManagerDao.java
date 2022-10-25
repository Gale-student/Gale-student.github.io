package com.company.dao;

import java.util.List;

import com.company.entity.Shop;
import com.company.entity.User;

public interface ManagerDao {
	//获取密码
	public String selectMpwd(String mid) throws Exception;
	//获取管理员姓名
	public String selectMname(String mid) throws Exception;
	//增加商品
	public int addShop(String sid, String sname, String stype, String scount, String sprice, String simage) throws Exception;
	//删除商品
	public void deleteShop(String sid) throws Exception;
	//修改商品价格
	public void updateShopSprice(String sid, String sprice) throws Exception;
	//修改商品库存
	public void updateShopScount(String sid, String scount) throws Exception;
	//修改商品图片
	public void updateShopSimage(String sid, String simage) throws Exception;
	//查看单个商品
	public List<Shop> selectOneShop(String sid) throws Exception;
	//查看所有商品
	public List<Shop> selectAllShop() throws Exception;
	//商品表分页
	public List<Shop> PagingQuery(int offset, int count) throws Exception;
	//获取商品表总行数
	public int allRows() throws Exception;
	//商品库存减少(用户下单)
	public void updateScount(String sid, String quantity) throws Exception;
	//商品库存增加(用户取消订单)
	public void updateRebackScount(String sid, String quantity) throws Exception;
	//根据商品名查找商品
	public List<Shop> selectShopBySname(String sname, int offset, int count) throws Exception;
	//获取根据商品名查找商品的总行数
	public int selectShopBySnameRows(String sname) throws Exception;

}
