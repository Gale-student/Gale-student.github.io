package com.company.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;
import com.company.entity.User;

public class OrdersDaoImpl implements OrdersDao {
	private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    private String username = "root";
    private String password = "root";
	
    //获取订单表总行数(管理员)
	public int OrdersAllRows() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from orders ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}
	
    //删除订单(管理员)
	public void deleteOrders(String oid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " delete from orders where oid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, oid);
		ps.execute();
		conn.close();

	}
	
    //订单表分页(管理员)
	public List<Orders> ordersPaging(int offset, int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from orders limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, offset);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String uid = rs.getString("uid");
			String sid = rs.getString("sid");
			String quantity = rs.getString("quantity");
			String date = rs.getString("date");
			String status = rs.getString("status");
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setUid(uid);
			orders.setSid(sid);
			orders.setQuantity(quantity);
			orders.setDate(date);
			orders.setStatus(status);
            ordersList.add(orders);
		}
		return ordersList;
	}
	
    //根据订单号查找订单(管理员)
	public List<Orders> selectOrdersByOid(String oid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from orders where oid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, oid);
		ResultSet rs = ps.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		while(rs.next()){
			String uid = rs.getString("uid");
			String sid = rs.getString("sid");
			String quantity = rs.getString("quantity");
			String date = rs.getString("date");
			String status = rs.getString("status");
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setUid(uid);
			orders.setSid(sid);
			orders.setQuantity(quantity);
			orders.setDate(date);
			orders.setStatus(status);
			ordersList.add(orders);
		}
		return ordersList;
	}
	
    //查看未支付订单(管理员)
	public List<Orders> selectOrdersByStatusUnpaid() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from orders where status = '0' ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String uid = rs.getString("uid");
			String sid = rs.getString("sid");
			String quantity = rs.getString("quantity");
			String date = rs.getString("date");
			String status = rs.getString("status");
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setUid(uid);
			orders.setSid(sid);
			orders.setQuantity(quantity);
			orders.setDate(date);
			orders.setStatus(status);
			ordersList.add(orders);
		}
		return ordersList;
	}
	
	//添加订单(用户购买)
	public void insertOrders(String oid, String uid, String sid, String quantity) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
//		System.currentTimeMillis();
//		String oid = "" + System.currentTimeMillis() + uid.subSequence(7, 11);
		String sql = " insert into orders values ( ?, ?, ?, ?, now(), 0 ) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, oid);
		ps.setString(2, uid);
		ps.setString(3, sid);
		ps.setString(4, quantity);
		ps.execute();
		conn.close();
		
	}
	
	//根据用户ID查询订单(管理员)
	public List<Orders> selectOrdersByUid(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from orders where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String sid = rs.getString("sid");
			String quantity = rs.getString("quantity");
			String date = rs.getString("date");
			String status = rs.getString("status");
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setUid(uid);
			orders.setSid(sid);
			orders.setQuantity(quantity);
			orders.setDate(date);
			orders.setStatus(status);
			ordersList.add(orders);
		}
		return ordersList;
	}
	
	//更新订单中商品数量(用户 添加相同商品)
	public void updateQuantity(String sid, String quantity) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update orders set quantity = quantity + ? where sid = ? and status = 0 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, quantity);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
	}
	
	//查询所有订单(管理员)
	public List<Orders> selectAllOrders() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from orders ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Orders> ordersList = new ArrayList<Orders>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String uid = rs.getString("uid");
			String sid = rs.getString("sid");
			String quantity = rs.getString("quantity");
			String date = rs.getString("date");
			String status = rs.getString("status");
			Orders orders = new Orders();
			orders.setOid(oid);
			orders.setUid(uid);
			orders.setSid(sid);
			orders.setQuantity(quantity);
			orders.setDate(date);
			orders.setStatus(status);
			ordersList.add(orders);
		}
		return ordersList;
	}
	
	//用户订单详情表分页
	public List<OrdersDetail> selectOrdersDetail(String uid, int offset, int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select o.oid, o.uid, s.sname, s.sprice, o.quantity,  " +
				"(o.quantity * s.sprice) as shopPrice, o.date, o.status from orders " +
				"o inner join shop s where s.sid = o.sid and o.uid = ? limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setInt(2, offset);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		List<OrdersDetail> ordersDetailList = new ArrayList<OrdersDetail>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String sname = rs.getString("sname");
			String sprice = rs.getString("sprice");
			String quantity = rs.getString("quantity");
			String shopPrice = rs.getString("shopPrice");
			String date = rs.getString("date");
			String status = rs.getString("status");
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setOid(oid);
			ordersDetail.setUid(uid);
			ordersDetail.setSname(sname);
			ordersDetail.setSprice(sprice);
			ordersDetail.setQuantity(quantity);
			ordersDetail.setShopPrice(shopPrice);
			ordersDetail.setDate(date);
			ordersDetail.setStatus(status);
			ordersDetailList.add(ordersDetail);
		}
		return ordersDetailList;
	}

	//获取用户订单详情表总行数
	public int OrdersDetailAllRows(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from orders where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		conn.close();
		return rows;
	}

	//获取用户未支付订单总行数
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from orders where uid = ? and status = 0 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		conn.close();
		return rows;
	}

	//查询用户未支付订单
	public List<OrdersDetail> selectOrdersDetailUnpaid(String uid, int offset,
			int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select o.oid, o.uid, s.sname, s.sprice, o.quantity,  " +
				"(o.quantity * s.sprice) as shopPrice, o.date, o.status from orders " +
				"o inner join shop s where s.sid = o.sid and o.uid = ? and o.status = 0 limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setInt(2, offset);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		List<OrdersDetail> ordersDetailList = new ArrayList<OrdersDetail>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String sname = rs.getString("sname");
			String sprice = rs.getString("sprice");
			String quantity = rs.getString("quantity");
			String shopPrice = rs.getString("shopPrice");
			String date = rs.getString("date");
			String status = rs.getString("status");
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setOid(oid);
			ordersDetail.setUid(uid);
			ordersDetail.setSname(sname);
			ordersDetail.setSprice(sprice);
			ordersDetail.setQuantity(quantity);
			ordersDetail.setShopPrice(shopPrice);
			ordersDetail.setDate(date);
			ordersDetail.setStatus(status);
			ordersDetailList.add(ordersDetail);
		}
		return ordersDetailList;
	}

	//获取用户未支付订单的总价
	public String selectTotalPriceOfUserUnpaidOrders(String uid)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select sum(o.quantity * s.sprice) as totalPrice from orders o inner join shop s where o.sid = s.sid and uid = ? and status = 0 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String totalPrice = rs.getString("totalPrice");
		return totalPrice;
	}

	//获取单个订单的总价
	public String selectOneOrdersTotalPrice(String uid, String oid)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select sum(o.quantity * s.sprice) as totalPrice from orders o inner join shop s where s.sid = o.sid and uid = ? and oid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setString(2, oid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		String totalPrice = rs.getString("totalPrice");
		return totalPrice;
	}

	//修改订单状态为已支付
	public void updateOrdersStatus(String oid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update orders set status = 1 , date = now() where oid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, oid);
		ps.execute();
		conn.close();
	}

	//查看已支付订单
	public List<OrdersDetail> selectPaidOrdersDetail(String uid, int offset, int count)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select o.oid, o.uid, s.sname, s.sprice, o.quantity,  " +
				"(o.quantity * s.sprice) as shopPrice, o.date, o.status from orders " +
				"o inner join shop s where s.sid = o.sid and o.uid = ? and o.status = 1 limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setInt(2, offset);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		List<OrdersDetail> ordersDetailList = new ArrayList<OrdersDetail>();
		while(rs.next()){
			String oid = rs.getString("oid");
			String sname = rs.getString("sname");
			String sprice = rs.getString("sprice");
			String quantity = rs.getString("quantity");
			String shopPrice = rs.getString("shopPrice");
			String date = rs.getString("date");
			String status = rs.getString("status");
			OrdersDetail ordersDetail = new OrdersDetail();
			ordersDetail.setOid(oid);
			ordersDetail.setUid(uid);
			ordersDetail.setSname(sname);
			ordersDetail.setSprice(sprice);
			ordersDetail.setQuantity(quantity);
			ordersDetail.setShopPrice(shopPrice);
			ordersDetail.setDate(date);
			ordersDetail.setStatus(status);
			ordersDetailList.add(ordersDetail);
		}
		return ordersDetailList;
	}

	public int selectPaidOrdersRows(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from orders where uid = ? and status = 1 ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		conn.close();
		return rows;
	}

}
