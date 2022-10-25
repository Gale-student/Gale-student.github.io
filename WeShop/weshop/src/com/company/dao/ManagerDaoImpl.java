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
	
	//���ҹ���Ա����
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

	//������Ʒ
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

	//ɾ����Ʒ
	public void deleteShop(String sid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " delete from shop where sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.execute();
		conn.close();
		
	}

	//������Ʒ���
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

	//������ƷͼƬ
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

	//������Ʒ�۸�
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

	//����������Ʒ
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

	//���ҵ�����Ʒ
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

	//��ȡ����Ա����
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

	//��Ʒ����ҳ
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

	//��Ʒ��������
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

	//���¼��ٿ��(�û��µ�)
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

	//���»������(�û�ȡ������)
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

	//������Ʒ��������Ʒ
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

	//��ȡ������Ʒ��������Ʒ��������
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