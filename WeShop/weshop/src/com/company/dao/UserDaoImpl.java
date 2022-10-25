package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.ShopCart;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UserDaoImpl implements UserDao {
    private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    private String username = "root";
    private String password = "root";
    
    //�����û�(ע��)
	public void insertUser(User user) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " insert into user (uid, upwd) values (?, ?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUid());
		ps.setString(2, user.getUpwd());
		ps.execute();
		conn.close();

	}
	
    //�����û���Ϣ(���Ƹ�����Ϣ)
	public void updateUserInfo(String uid, String uname,String uaddress,String ugender,String uage,String utel, String uimage) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update user set uname = ?, uaddress = ?, ugender = ?, uage = ?, utel= ?, uimage = ? where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		User user = new User();
		user.setUid(uid);
		ps.setString(1, uname);
		ps.setString(2, uaddress);
		ps.setString(3, ugender);
		ps.setString(4, uage);
		ps.setString(5, utel);
		ps.setString(6, uimage);
		ps.setString(7, uid);
		ps.execute();
		conn.close();
	}
	
    //��������
	public String selectUpwd(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select upwd from user where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		String upwd = "";
		while(rs.next()){
			upwd = rs.getString("upwd");
		}
		conn.close();
		return upwd;
	}
	
    //����ͷ��
	public String selectUimage(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select uimage from user where uid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		String uimage = "";
		while(rs.next()){
			uimage = rs.getString("uimage");
		}
		return uimage;
	}
	
    //��������
	public void updateUpwd(String uid, String upwd) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update user set upwd = ? where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, upwd);
		ps.setString(2, uid);
		ps.execute();
		conn.close();
	}
	
	//�û�����ҳ
	public List<User> PagingQuery(int offset, int count) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from user limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, offset);
		ps.setInt(2, count);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		while(rs.next()){
			String uid = rs.getString("uid");
			String upwd = rs.getString("upwd");
			String uname = rs.getString("uname");
			String uaddress = rs.getString("uaddress");
			String ugender = rs.getString("ugender");
			String uage = rs.getString("uage");
			String utel = rs.getString("utel");
			String uimage = rs.getString("uimage");
			User user = new User();
			user.setUid(uid);
			user.setUpwd(upwd);
			user.setUname(uname);
			user.setUaddress(uaddress);
			user.setUgender(ugender);
			user.setUage(uage);
			user.setUtel(utel);
			user.setUimage(uimage);
			userList.add(user);
		}
		return userList;
	}
	
	//��ȡ�û���������
	public int allRows() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from user ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}
	
    //�������е��û�ID
	public List<String> selectAllUid() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select uid from user ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<String> uidList = new ArrayList<String>();
		while(rs.next()){
			String uid = rs.getString("uid");
			uidList.add(uid);
		}
		return uidList;
	}
	
    //�鿴�����û�����Ϣ
	public List<User> selectUserInforById(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select * from user where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		List<User> uidList = new ArrayList<User>();
		while(rs.next()){
			String uname = rs.getString("uname");
			String uaddress = rs.getString("uaddress");
			String ugender = rs.getString("ugender");
			String uage = rs.getString("uage");
			String uimage = rs.getString("uimage");
			String utel = rs.getString("utel");
			User user = new User();
			user.setUid(uid);
			user.setUname(uname);
			user.setUaddress(uaddress);
			user.setUgender(ugender);
			user.setUage(uage);
			user.setUtel(utel);
			user.setUimage(uimage);
			uidList.add(user);
		}
		return uidList;
	}
	
    // ɾ���û�
	public void deleteUser(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " delete from user where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.execute();
		conn.close();
	}
	
    //�޸ĵ�ַ
	public void updateUaddress(String uid, String uaddress) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update user set uaddress = ? where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uaddress);
		ps.setString(2, uid);
		ps.execute();
		conn.close();
		
	}
	
    //�޸���ϵ��ʽ
	public void updateUtel(String uid, String utel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update user set utel = ? where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, utel);
		ps.setString(2, uid);
		ps.execute();
		conn.close();
		
	}
	
	//�˳���¼
	public void logout(HttpSession session) throws Exception {
		
		session.removeAttribute("uid");
		session.invalidate();
	}
	
	//�༭�޸ĸ�����Ϣ
	public void updateInfo(String uid, String uname, String uaddress,
			String ugender, String uage, String utel) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update user set uname = ?, uaddress = ?, ugender = ?, uage = ?, utel= ? where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		User user = new User();
		user.setUid(uid);
		ps.setString(1, uname);
		ps.setString(2, uaddress);
		ps.setString(3, ugender);
		ps.setString(4, uage);
		ps.setString(5, utel);
		ps.setString(6, uid);
		ps.execute();
		conn.close();
		
	}
	
	//���ӹ��ﳵ
	public void insertShopCart(String sid, String uid, String shopQuantity)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " insert into shopCart values ( ?, ?, ? ) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, uid);
		ps.setString(3, shopQuantity);
		ps.execute();
		conn.close();
		
	}
	
	//�鿴���ﳵ����
	public List<ShopCartDetail> selectCart(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select s.sid, s.sname, s.stype, s.sprice, c.shopQuantity, " +
				     "s.sprice * c.shopQuantity as shopPrice from shopCart c inner join shop s where s.sid = c.sid" +
				     " and uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		List<ShopCartDetail> shopCartDetailList = new ArrayList<ShopCartDetail>();
		while(rs.next()){
			String sid = rs.getString("sid");
			String sname = rs.getString("sname");
			String stype = rs.getString("stype");
			String sprice = rs.getString("sprice");
			String shopQuantity = rs.getString("shopQuantity");
			String shopPrice = rs.getString("shopPrice");
			ShopCartDetail shopCartDetail = new ShopCartDetail();
			shopCartDetail.setSid(sid);
			shopCartDetail.setSname(sname);
			shopCartDetail.setStype(stype);
			shopCartDetail.setSprice(sprice);
			shopCartDetail.setShopQuantity(shopQuantity);
			shopCartDetail.setShopPrice(shopPrice);
			shopCartDetailList.add(shopCartDetail);
		}
		return shopCartDetailList;
	}
	
	//���¹��ﳵ��Ʒ����
	public void updateShopQuantity(String uid, String sid, String shopQuantity) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " update shopCart set shopQuantity = shopQuantity + ? where sid = ? and uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, shopQuantity);
		ps.setString(2, sid);
		ps.setString(3, uid);
		ps.execute();
		conn.close();
	}
	
	//���ﳵ�ܼ�
	public String selectSumPrice(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select sum(c.shopQuantity * s.sprice) as totalPrice from " +
				"shopCart c inner join shop s where s.sid = c.sid and uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		String totalPrice = "";
		while(rs.next()){
			totalPrice = rs.getString("totalPrice");
		}
		return totalPrice;
	}
	
	//��ȡ���ﳵ������
	public int shopCartAllRows(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from shopCart where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}
	
	//���ﳵ�������ҳ
	public List<ShopCartDetail> ShopCartPagingQuery(int offset, int count, String uid)
			throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select s.sid, s.sname, s.stype, s.sprice, c.shopQuantity, " +
				     "s.sprice * c.shopQuantity as shopPrice from shopCart c inner " +
				     "join shop s where s.sid = c.sid" +
				     " and uid = ? limit ?, ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setInt(2, offset);
		ps.setInt(3, count);
		ResultSet rs = ps.executeQuery();
		List<ShopCartDetail> shopCartDetailList = new ArrayList<ShopCartDetail>();
		while(rs.next()){
			String sid = rs.getString("sid");
			String sname = rs.getString("sname");
			String stype = rs.getString("stype");
			String sprice = rs.getString("sprice");
			String shopQuantity = rs.getString("shopQuantity");
			String shopPrice = rs.getString("shopPrice");
			ShopCartDetail shopCartDetail = new ShopCartDetail();
			shopCartDetail.setSid(sid);
			shopCartDetail.setSname(sname);
			shopCartDetail.setStype(stype);
			shopCartDetail.setSprice(sprice);
			shopCartDetail.setShopQuantity(shopQuantity);
			shopCartDetail.setShopPrice(shopPrice);
			shopCartDetailList.add(shopCartDetail);
		}
		return shopCartDetailList;
	}
	
	//ɾ�����ﳵ��Ʒ
	public void deleteShopInCart(String uid, String sid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " delete from shopCart where uid = ? and sid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.setString(2, sid);
		ps.execute();
		conn.close();
	}
	
	//��ѯ�û����ж���
	public List<Orders> selectAllOrders(String uid) throws Exception {
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
	
	//��ȡ�û����ж���������
	public int userAllOrdersAllRows(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = " select count(*) as rows from orders where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int rows = rs.getInt("rows");
		return rows;
	}
	
	//ɾ���û����ﳵ��Ʒ
	public void deleteShopCart(String uid) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "delete from shopCart where uid = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ps.execute();
		conn.close();
	}

}