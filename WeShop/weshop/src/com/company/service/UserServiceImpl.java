package com.company.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.entity.Orders;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    
    //用户注册
	public void userRegister(User user) throws Exception {
		userDao.insertUser(user);
	}
	
    //完善个人信息
	public void completePersonalInfo(String uid, String uname,String uaddress,
			String ugender,String uage,String utel, String uimage) throws Exception {
		
		userDao.updateUserInfo(uid, uname, uaddress, ugender, uage, utel, uimage);
	}
	
	//用户登录
	public String userLogin(String uid, String upwd) throws Exception {
		String pwd = userDao.selectUpwd(uid);
		if(pwd.equals("") || pwd == null){
			return "账号不存在";
		}else{
			if(pwd.equals(upwd)){
				return "登录成功";
			}
			return "密码错误";
		}
	}
	
	//用户头像展示
	public String userImageDisplay(String uid) throws Exception {
		String uimage = userDao.selectUimage(uid);
		return uimage;
	}
	
	//修改用户密码
	public void modifyUserUpwd(String uid, String upwd) throws Exception {
		userDao.updateUpwd(uid, upwd);
	}
	
	//用户表分页
	public List<User> PagingQuery(int page) throws Exception {
		List<User> userList = userDao.PagingQuery(page * 3, 3);
		return userList;
	}
	
	//用户表总行数
	public int AllRows() throws Exception {
		int rows = userDao.allRows();
		return rows;
	}
	
	//查找所有用户id
	public List<String> queryAllUid() throws Exception {
		List<String> uidList = userDao.selectAllUid();
		return uidList;
	}
	
	//查看用户信息
	public List<User> queryUserInfo(String uid) throws Exception {
		List<User> userList = userDao.selectUserInforById(uid);
		return userList;
	}
	
	//用户注销(删除用户)
	public void deleteUser(String uid) throws Exception {
		userDao.deleteUser(uid);
	}
	
	//修改用户地址
	public void modifyUserUaddress(String uid, String uaddress)
			throws Exception {
		userDao.updateUaddress(uid, uaddress);
	}
	
	//修改用户联系方式
	public void modifyUserUtel(String uid, String utel) throws Exception {
		userDao.updateUtel(uid, utel);
		
	}
	
	//退出登录
	public void logout(HttpSession session) throws Exception {
		userDao.logout(session);
	}
	
	//编辑个人信息
	public void editInfo(String uid, String uname, String uaddress,
			String ugender, String uage, String utel) throws Exception {
		userDao.updateInfo(uid, uname, uaddress, ugender, uage, utel);
		
	}
	
	//添加到购物车
	public void addShopCart(String sid, String uid, String shopQuantity)
			throws Exception {
		userDao.insertShopCart(sid, uid, shopQuantity);
	}
	
	//查看购物车
	public List<ShopCartDetail> quaryCart(String uid) throws Exception {
		List<ShopCartDetail> shopCartDetail = userDao.selectCart(uid);
		return shopCartDetail;
	}
	
	//添加购物车商品数量
	public void addShopQuantity(String uid, String sid, String shopQuantity)
			throws Exception {
		userDao.updateShopQuantity(uid, sid, shopQuantity);
		
	}
	
	//购物车商品总价
	public String SumPrice(String uid) throws Exception {
		String sumPrice = userDao.selectSumPrice(uid);
		return sumPrice;
	}
	
	//获取购物车表总行数
	public int shopCartAllRows(String uid) throws Exception {
		int shopCartAllRows =  userDao.shopCartAllRows(uid);
		return shopCartAllRows;
	}
	
	//购物车详情表分页
	public List<ShopCartDetail> ShopCartPagingQuery(int page, String uid) throws Exception {
		List<ShopCartDetail> shopCartDetailList = userDao.ShopCartPagingQuery(page * 3, 3, uid);
		return shopCartDetailList;
	}
	
	//删除购物车商品
	public void deleteShopInCart(String uid, String sid) throws Exception {
		userDao.deleteShopInCart(uid, sid);
	}
	
	//查询用户所有订单
	public List<Orders> queryAllOrders(String uid) throws Exception {
		List<Orders> ordersList = userDao.selectAllOrders(uid);
		return ordersList;
	}

	//清空购物车
	public void removeShopCart(String uid) throws Exception {
		userDao.deleteShopCart(uid);
		
	}


}
