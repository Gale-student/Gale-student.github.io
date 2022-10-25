package com.company.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.ShopCart;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public interface UserDao {
	//插入用户
	public void insertUser(User user) throws Exception;
    //更新所有信息
	public void updateUserInfo(String uid, String uname,String uaddress,String ugender,String uage,String utel, String uimage) throws Exception;
	//查找密码
	public String selectUpwd(String uid) throws Exception;
	//用户头像获取
	public String selectUimage(String uid) throws Exception;
	//修改密码
	public void updateUpwd(String uid, String upwd) throws Exception;
	//用户表分页
	public List<User> PagingQuery(int offset, int count) throws Exception;
	//获取用户表总行数
	public int allRows() throws Exception;
	//获取后台所有用户账号
	public List<String> selectAllUid() throws Exception;
	//获取单个用户信息
	public List<User> selectUserInforById(String uid) throws Exception;
	//删除用户
	public void deleteUser(String uid) throws Exception;
	//修改地址
	public void updateUaddress(String uid, String uaddress) throws Exception;
	//修改联系方式
	public void updateUtel(String uid, String utel) throws Exception;
	//修改除头像以外的信息
	public void updateInfo(String uid, String uname, String uaddress, String ugender, String uage, String utel) throws Exception;
	//退出登录
	public void logout(HttpSession session) throws Exception;
	//添加到购物车
	public void insertShopCart(String sid, String uid, String shopQuantity) throws Exception;
	//查看购物车详情页
	public List<ShopCartDetail> selectCart(String uid) throws Exception;
	//增加购物车商品数量
	public void updateShopQuantity(String uid, String sid, String shopQuantity) throws Exception;
	//购物车商品总价求和
	public String selectSumPrice(String uid) throws Exception; 
	//获取购物车总行数
	public int shopCartAllRows(String uid) throws Exception;
	//购物车详情表分页
	public List<ShopCartDetail> ShopCartPagingQuery(int offset, int count, String uid) throws Exception;
	//删除购物车商品
	public void deleteShopInCart(String uid, String sid) throws Exception;
	//查询用户所有订单
	public List<Orders> selectAllOrders(String uid) throws Exception;
	//获取用户所有订单总行数
	public int userAllOrdersAllRows(String uid) throws Exception;
	//删除购物车商品
	public void deleteShopCart(String uid) throws Exception;
}
