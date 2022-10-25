package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.entity.Shop;
import com.company.entity.User;



public class ManagerDaoImpl implements ManagerDao {
    private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	private String username = "root";
	private String password = "root";
	
	//查找管理员密码
	public String selectMpwd(String mid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "select * from manager where mid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mid);
		ResultSet rs = ps.executeQuery();
		String mpwd = "";
		while(rs.next()){
			mpwd = rs.getString("mpwd");
		}
		return mpwd;
	}

	//添加商品
	public int addShop(String sid, String sname, String stype, String scount, String sprice, String simage) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " insert into shop values(?, ?, ?, ?, ?, ?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, sname);
		ps.setString(3, stype);
		ps.setString(4, scount);
		ps.setString(5, sprice);
		ps.setString(6, simage);
		int res = ps.executeUpdate();
		conn.close();
		return res;
	}

	//删除商品
	public void deleteShop(String sid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " delete from shop where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.execute();
		conn.close();
		
	}

	//更新商品库存
	public void updateShopScount(String sid, String scount) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shop set scount = ? where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, scount);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
		
	}

	//更新商品图片
	public void updateShopSimage(String sid, String simage) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shop set simage = ? where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, simage);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
		
	}

	//更新商品价格
	public void updateShopSprice(String sid, String sprice) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shop set sprice = ? where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sprice);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
		
	}

	//查找所有商品
	public List<Shop> selectAllShop() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from shop ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Shop> shopList = new ArrayList<Shop>();
		while(rs.next()){
			String sid = rs.getString("sid");
			String sname = rs.getString("sname");
			String stype = rs.getString("stype");
			String scount = rs.getString("scount");
			String sprice = rs.getString("sprice");
			String simage = rs.getString("simage");
			Shop shop = new Shop();
			shop.setSid(sid);
			shop.setSname(sname);
			shop.setStype(stype);
			shop.setScount(scount);
			shop.setSprice(sprice);
			shop.setSimage(simage);
			shopList.add(shop);
		}
		return shopList;
	}

	//查找单个商品
	public List<Shop> selectOneShop(String sid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from shop where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sid);
		ResultSet rs = ps.executeQuery();
		List<Shop> shopList = new ArrayList<Shop>();
		while(rs.next()){
			String id = rs.getString("sid");
			String sname = rs.getString("sname");
			String stype = rs.getString("stype");
			String scount = rs.getString("scount");
			String sprice = rs.getString("sprice");
			String simage = rs.getString("simage");
			Shop shop = new Shop();
			shop.setSid(id);
			shop.setSname(sname);
			shop.setStype(stype);
			shop.setScount(scount);
			shop.setSprice(sprice);
			shop.setSimage(simage);
			shopList.add(shop);
		}
		return shopList;
	}

	//获取管理员姓名
	public String selectMname(String mid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "select * from manager where mid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, mid);
		ResultSet rs = ps.executeQuery();
		String mname = "";
		while(rs.next()){
			mname = rs.getString("mname");
		}
		return mname;
	}

	//商品表分页
	public List<Shop> PagingQuery(int offset, int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from shop limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, offset);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<Shop> shopList = new ArrayList<Shop>();
		while(rs.next()){
			String sid = rs.getString("sid");
			String sname = rs.getString("sname");
			String stype = rs.getString("stype");
			String scount = rs.getString("scount");
			String sprice = rs.getString("sprice");
			String simage = rs.getString("simage");
			Shop shop = new Shop();
			shop.setSid(sid);
			shop.setSname(sname);
			shop.setStype(stype);
			shop.setScount(scount);
			shop.setSprice(sprice);
			shop.setSimage(simage);
			shopList.add(shop);
		}
		return shopList;
	}

	//商品表总行数
	public int allRows() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from shop ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}

	//更新减少库存(用户下单)
	public void updateScount(String sid, String quantity) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shop set scount = scount - ? where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, quantity);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
		
	}

	//更新回增库存(用户取消订单)
	public void updateRebackScount(String sid, String quantity)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shop set scount = scount + ? where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, quantity);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
		
	}

	//根据商品名查找商品
	public List<Shop> selectShopBySname(String sname, int offset, int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from shop where sname = ? limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sname);
		ps.setInt(2, offset);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		List<Shop> shopList = new ArrayList<Shop>();
		while(rs.next()){
			String sid = rs.getString("sid");
			String stype = rs.getString("stype");
			String sprice = rs.getString("sprice");
			String scount = rs.getString("scount");
			String simage = rs.getString("simage");
			Shop shop = new Shop();
			shop.setSid(sid);
			shop.setSname(sname);
			shop.setStype(stype);
			shop.setSprice(sprice);
			shop.setScount(scount);
			shop.setSimage(simage);
			shopList.add(shop);
		}
		return shopList;
	}

	//获取根据商品名查找商品的总行数
	public int selectShopBySnameRows(String sname) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from shop where sname = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sname);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}

}
