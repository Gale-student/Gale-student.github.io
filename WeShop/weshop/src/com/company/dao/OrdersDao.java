package com.company.dao;

import java.util.List;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;

public interface OrdersDao {
	//删除订单(取消订单)
	public void deleteOrders(String oid) throws Exception;
	//订单表分页
	public List<Orders> ordersPaging(int offset, int count) throws Exception;
	//获取订单表总行数
	public int OrdersAllRows() throws Exception;
	//根据订单号查找订单
	public List<Orders> selectOrdersByOid(String oid) throws Exception;
	//查看未支付订单
	public List<Orders> selectOrdersByStatusUnpaid() throws Exception;
	//用户下单(添加订单)
	public void insertOrders(String oid, String uid, String sid, String quantity) throws Exception;
	//根据用户ID查订单
	public List<Orders> selectOrdersByUid(String uid) throws Exception;
	//更新订单中商品数量
	public void updateQuantity(String sid, String quantity) throws Exception;
	//查寻所有订单
	public List<Orders> selectAllOrders() throws Exception;
	//订单详情表分页(用户)
	public List<OrdersDetail> selectOrdersDetail(String uid, int offset, int count) throws Exception;
	//获取用户订单表总行数
	public int OrdersDetailAllRows(String uid) throws Exception;
	//用户未支付订单分页查询
	public List<OrdersDetail> selectOrdersDetailUnpaid(String uid, int offset, int count) throws Exception;
	//获取用户未支付订单表总行数
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception;
	//获取所有未支付订单的总价
	public String selectTotalPriceOfUserUnpaidOrders(String uid) throws Exception;
	//获取单个订单的总价
	public String selectOneOrdersTotalPrice(String uid, String oid) throws Exception;
	//修改订单状态
	public void updateOrdersStatus(String oid) throws Exception;
	//查看用户已支付订单
	public List<OrdersDetail> selectPaidOrdersDetail(String uid, int offset, int count) throws Exception;
	//获取用户已支付订单的总行数
	public int selectPaidOrdersRows(String uid) throws Exception;
}
