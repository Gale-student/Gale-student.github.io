package com.company.service;

import java.util.List;

import com.company.dao.OrdersDao;
import com.company.dao.OrdersDaoImpl;
import com.company.entity.Orders;
import com.company.entity.OrdersDetail;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao = new OrdersDaoImpl();
	
    //获取订单表总行数
	public int OrdersAllRows() throws Exception {
		int ordersAllRows = ordersDao.OrdersAllRows();
		return ordersAllRows;
	}
	
    //添加订单(购买 下单 默认未支付状态)
	public void addOrders(String oid, String uid, String sid, String quantity)
			throws Exception {
		ordersDao.insertOrders(oid, uid, sid, quantity);
	}
	
    //取消订单
	public void cancelOrders(String oid) throws Exception {
		ordersDao.deleteOrders(oid);
	}
	
    //订单表分页
	public List<Orders> ordersPagingQuery(int page) throws Exception {
		List<Orders> ordersList = ordersDao.ordersPaging(page * 3, 3);
		return ordersList;
	}
	
    //根据订单编号查订单
	public List<Orders> queryOrdersByOid(String oid) throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByOid(oid);
		return ordersList;
	}
	
    //查看未支付订单
	public List<Orders> queryOrdersByStatusUnpaid() throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByStatusUnpaid();
		return ordersList;
	}
	
	//通过用户ID查订单
	public List<Orders> queryOrdersByUid(String uid) throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByUid(uid);
		return ordersList;
	}
	
	//修改商品数量
	public void modifyQuantity(String sid, String quantity) throws Exception {
		ordersDao.updateQuantity(sid, quantity);
	}
	
	//查找所有订单
	public List<Orders> queryAllOrders() throws Exception {
		List<Orders> ordersList = ordersDao.selectAllOrders();
		return ordersList;
	}
	
	//查看用户所有订单详情
	public List<OrdersDetail> selectOrdersDetail(String uid, int page) throws Exception {
		List<OrdersDetail> ordersDetailList = ordersDao.selectOrdersDetail(uid, page * 3, 3);
		return ordersDetailList;
	}
    
	//获取用户订单表总行数
	public int OrdersDetailAllRows(String uid) throws Exception {
		int ordersDetailAllRows = ordersDao.OrdersDetailAllRows(uid);
		return ordersDetailAllRows;
	}

	//获取用户未支付订单总行数
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception {
		int ordersDetailUnpaidAllRows = ordersDao.OrdersDetailUnpaidAllRows(uid);
		return ordersDetailUnpaidAllRows;
	}

	//查看用户未支付订单详情
	public List<OrdersDetail> queryOrdersDetailUnpaid(String uid, int page) throws Exception {
		List<OrdersDetail> ordersDetaiUnpaidlList = ordersDao.selectOrdersDetailUnpaid(uid, page * 3, 3);
		return ordersDetaiUnpaidlList;
	}

	//
	public String queryTotalPriceOfUserUnpaidOrders(String uid)
			throws Exception {
		String totalPrice = ordersDao.selectTotalPriceOfUserUnpaidOrders(uid);
		return totalPrice;
	}

	public String queryOneOrdersTotalPrice(String uid, String oid)
			throws Exception {
		String totalPrice = ordersDao.selectOneOrdersTotalPrice(uid, oid);
		return totalPrice;
	}

	public void modifyOrdersStatus(String oid) throws Exception {
		ordersDao.updateOrdersStatus(oid);
		
	}

	public List<OrdersDetail> queryPaidOrdersDetail(String uid, int page)
			throws Exception {
		List<OrdersDetail> ordersDetaiPaidlList = ordersDao.selectPaidOrdersDetail(uid, page * 3, 3);
		return ordersDetaiPaidlList;
	}

	public int queryPaidOrdersRows(String uid) throws Exception {
		int rows = ordersDao.selectPaidOrdersRows(uid);
		return rows;
	}


}
