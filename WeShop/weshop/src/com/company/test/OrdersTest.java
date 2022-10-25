package com.company.test;

import java.util.List;

import com.company.dao.OrdersDao;
import com.company.dao.OrdersDaoImpl;
import com.company.entity.Orders;

public class OrdersTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		OrdersDao ordersDao = new OrdersDaoImpl();
//		int a = ordersDao.OrdersAllRows();
//        System.out.println(a);
//        ordersDao.insertOrders("18020229999", "s103", "26");
//        List<Orders> ordersList = ordersDao.selectOrdersByStatusUnpaid();
//        for(Orders orders : ordersList){
//        	System.out.println(orders);
//        }
		String a = ordersDao.selectTotalPriceOfUserUnpaidOrders("17768274373");
		System.out.println(a);
		String b = ordersDao.selectOneOrdersTotalPrice("17768274373", "s43731664270837179");
		System.out.println(b);
	}

}
