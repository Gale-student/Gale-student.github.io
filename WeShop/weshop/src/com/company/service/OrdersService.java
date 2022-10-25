package com.company.service;

import java.util.List;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;
import com.company.entity.User;

public interface OrdersService {
	//删除订单(取消订单)
	public void cancelOrders(String oid) throws Exception;
	//分页
	public List<Orders> ordersPagingQuery(int page) throws Exception;
	//获取订单表总行数
	public int OrdersAllRows() throws Exception;
	//根据订单号查找订单
	public List<Orders> queryOrdersByOid(String oid) throws Exception;
	//查看未支付订单
	public List<Orders> queryOrdersByStatusUnpaid() throws Exception;
	//用户下单(添加订单)
	public void addOrders(String oid, String uid, String sid, String quantity) throws Exception;
	//根据用户ID查订单
	public List<Orders> queryOrdersByUid(String uid) throws Exception;
	//更新订单中商品数量
	public void modifyQuantity(String sid, String quantity) throws Exception;
	//查寻所有订单
	public List<Orders> queryAllOrders() throws Exception;
	//订单详情表分页(用户)
	public List<OrdersDetail> selectOrdersDetail(String uid, int page) throws Exception;
	//获取用户订单表总行数
	public int OrdersDetailAllRows(String uid) throws Exception;
	//用户未支付订单分页查询
	public List<OrdersDetail> queryOrdersDetailUnpaid(String uid, int page) throws Exception;
	//获取用户未支付订单表总行数
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception;
	//获取所有未支付订单的总价
	public String queryTotalPriceOfUserUnpaidOrders(String uid) throws Exception;
	//获取单个订单的总价
	public String queryOneOrdersTotalPrice(String uid, String oid) throws Exception;
	//修改订单状态
	public void modifyOrdersStatus(String oid) throws Exception;
	//查看已支付订单
	public List<OrdersDetail> queryPaidOrdersDetail(String uid, int page) throws Exception;
	//获取用户已支付订单的总行数
	public int queryPaidOrdersRows(String uid) throws Exception;
}
