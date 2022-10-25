package com.company.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public interface UserService {
	//用户注册
	public void userRegister(User user) throws Exception;
    //完善个人信息
	public void completePersonalInfo(String uid, String uname,String uaddress,String ugender,String uage,String utel, String uimage) throws Exception;
	//用户登录name
	public String userLogin(String uid, String upwd) throws Exception;
	//用户个人头像展示
	public String userImageDisplay(String uid) throws Exception;
	//修改密码
	public void modifyUserUpwd(String uid, String upwd) throws Exception;
	//分页
	public List<User> PagingQuery(int page) throws Exception;
	//获取行数
	public int AllRows() throws Exception;
	//获取后台所有用户账号
	public List<String> queryAllUid() throws Exception;
	//获取用户信息
	public List<User> queryUserInfo(String uid) throws Exception;
	//用户注销
	public void deleteUser(String uid) throws Exception;
	//修改地址
	public void modifyUserUaddress(String uid, String uaddress) throws Exception;
	//修改联系方式
	public void modifyUserUtel(String uid, String utel) throws Exception;
	//退出登录
	public void logout(HttpSession session) throws Exception;
	//编辑个人信息
	public void editInfo(String uid, String uname, String uaddress, String ugender, String uage, String utel) throws Exception;
	//添加到购物车
	public void addShopCart(String sid, String uid, String shopQuantity) throws Exception;
	//查看购物车详情页
	public List<ShopCartDetail> quaryCart(String uid) throws Exception;
	//增加购物车商品数量
	public void addShopQuantity(String uid, String sid, String shopQuantity) throws Exception;
	//购物车商品总价求和
	public String SumPrice(String uid) throws Exception; 
	//获取购物车总行数
	public int shopCartAllRows(String uid) throws Exception;
	//购物车详情表分页
	public List<ShopCartDetail> ShopCartPagingQuery(int page, String uid) throws Exception;
	//删除购物车商品
	public void deleteShopInCart(String uid, String sid) throws Exception;
	//查询用户所有订单
	public List<Orders> queryAllOrders(String uid) throws Exception;
	//删除购物车商品
	public void removeShopCart(String uid) throws Exception;
}
