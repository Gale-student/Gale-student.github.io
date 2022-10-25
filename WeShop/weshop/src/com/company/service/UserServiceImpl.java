package com.company.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;
import com.company.entity.Orders;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    
    //�û�ע��
	public void userRegister(User user) throws Exception {
		userDao.insertUser(user);
	}
	
    //���Ƹ�����Ϣ
	public void completePersonalInfo(String uid, String uname,String uaddress,
			String ugender,String uage,String utel, String uimage) throws Exception {
		
		userDao.updateUserInfo(uid, uname, uaddress, ugender, uage, utel, uimage);
	}
	
	//�û���¼
	public String userLogin(String uid, String upwd) throws Exception {
		String pwd = userDao.selectUpwd(uid);
		if(pwd.equals("") || pwd == null){
			return "�˺Ų�����";
		}else{
			if(pwd.equals(upwd)){
				return "��¼�ɹ�";
			}
			return "�������";
		}
	}
	
	//�û�ͷ��չʾ
	public String userImageDisplay(String uid) throws Exception {
		String uimage = userDao.selectUimage(uid);
		return uimage;
	}
	
	//�޸��û�����
	public void modifyUserUpwd(String uid, String upwd) throws Exception {
		userDao.updateUpwd(uid, upwd);
	}
	
	//�û�����ҳ
	public List<User> PagingQuery(int page) throws Exception {
		List<User> userList = userDao.PagingQuery(page * 3, 3);
		return userList;
	}
	
	//�û���������
	public int AllRows() throws Exception {
		int rows = userDao.allRows();
		return rows;
	}
	
	//���������û�id
	public List<String> queryAllUid() throws Exception {
		List<String> uidList = userDao.selectAllUid();
		return uidList;
	}
	
	//�鿴�û���Ϣ
	public List<User> queryUserInfo(String uid) throws Exception {
		List<User> userList = userDao.selectUserInforById(uid);
		return userList;
	}
	
	//�û�ע��(ɾ���û�)
	public void deleteUser(String uid) throws Exception {
		userDao.deleteUser(uid);
	}
	
	//�޸��û���ַ
	public void modifyUserUaddress(String uid, String uaddress)
			throws Exception {
		userDao.updateUaddress(uid, uaddress);
	}
	
	//�޸��û���ϵ��ʽ
	public void modifyUserUtel(String uid, String utel) throws Exception {
		userDao.updateUtel(uid, utel);
		
	}
	
	//�˳���¼
	public void logout(HttpSession session) throws Exception {
		userDao.logout(session);
	}
	
	//�༭������Ϣ
	public void editInfo(String uid, String uname, String uaddress,
			String ugender, String uage, String utel) throws Exception {
		userDao.updateInfo(uid, uname, uaddress, ugender, uage, utel);
		
	}
	
	//���ӵ����ﳵ
	public void addShopCart(String sid, String uid, String shopQuantity)
			throws Exception {
		userDao.insertShopCart(sid, uid, shopQuantity);
	}
	
	//�鿴���ﳵ
	public List<ShopCartDetail> quaryCart(String uid) throws Exception {
		List<ShopCartDetail> shopCartDetail = userDao.selectCart(uid);
		return shopCartDetail;
	}
	
	//���ӹ��ﳵ��Ʒ����
	public void addShopQuantity(String uid, String sid, String shopQuantity)
			throws Exception {
		userDao.updateShopQuantity(uid, sid, shopQuantity);
		
	}
	
	//���ﳵ��Ʒ�ܼ�
	public String SumPrice(String uid) throws Exception {
		String sumPrice = userDao.selectSumPrice(uid);
		return sumPrice;
	}
	
	//��ȡ���ﳵ��������
	public int shopCartAllRows(String uid) throws Exception {
		int shopCartAllRows =  userDao.shopCartAllRows(uid);
		return shopCartAllRows;
	}
	
	//���ﳵ�������ҳ
	public List<ShopCartDetail> ShopCartPagingQuery(int page, String uid) throws Exception {
		List<ShopCartDetail> shopCartDetailList = userDao.ShopCartPagingQuery(page * 3, 3, uid);
		return shopCartDetailList;
	}
	
	//ɾ�����ﳵ��Ʒ
	public void deleteShopInCart(String uid, String sid) throws Exception {
		userDao.deleteShopInCart(uid, sid);
	}
	
	//��ѯ�û����ж���
	public List<Orders> queryAllOrders(String uid) throws Exception {
		List<Orders> ordersList = userDao.selectAllOrders(uid);
		return ordersList;
	}

	//��չ��ﳵ
	public void removeShopCart(String uid) throws Exception {
		userDao.deleteShopCart(uid);
		
	}


}