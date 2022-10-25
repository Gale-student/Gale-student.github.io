package com.company.test;

import java.util.List;

import com.company.dao.ManagerDao;
import com.company.dao.ManagerDaoImpl;
import com.company.entity.Shop;

public class ShopTest {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
		ManagerDao managerDao = new ManagerDaoImpl();
//		managerDao.updateShopScount("s101", "999");
//		managerDao.updateShopSprice("s101", "2");
//		managerDao.updateShopSimage("s101", "2.jpg");
		List<Shop> shopList = managerDao.selectOneShop("s102");
		System.out.println(shopList);
		List<Shop> allshopList = managerDao.selectAllShop();
		System.out.println(allshopList);
	}

}
