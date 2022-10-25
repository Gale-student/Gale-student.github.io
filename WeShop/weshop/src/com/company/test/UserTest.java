package com.company.test;

import java.util.List;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UserTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl();
		List<ShopCartDetail> a = userService.ShopCartPagingQuery(0,"17768274373");
		System.out.println(a);
//		String a = userService.SumPrice("17768274373");
//		System.out.println(a);
//		List<User> userList = userService.PagingQuery(0, 3);
//        System.out.println(userList);
//        System.out.println(userList.size());
//        int rows = userDao.allRows();
//        System.out.println(rows);
//        List<String> uidList = userDao.selectAllUid();
//        for(String uid : uidList){
//        	System.out.println(uid);
//        }
		/*
		List<String> uidList = userService.queryAllUid();
		for(String uid : uidList){
        	System.out.println(uid);
        }
        */
//		List<User> userList = userDao.selectUserInforById("18020222856");
//		for( User user : userList){
//			System.out.println(user);
//		}
//		List<User> userList = userService.queryUserInfo("18020222856");
//		for( User user : userList){
//			System.out.println(user);
//		}
		//userDao.deleteUser("u101");
		String a1 = "20";
		String a2 = "30";
		String res = a1 + " + " + a2;
		
		System.out.println(res);
		
		
		
	}

}
