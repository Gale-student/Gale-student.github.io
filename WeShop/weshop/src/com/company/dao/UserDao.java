package com.company.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.ShopCart;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public interface UserDao {
	//�����û�
	public void insertUser(User user) throws Exception;
    //����������Ϣ
	public void updateUserInfo(String uid, String uname,String uaddress,String ugender,String uage,String utel, String uimage) throws Exception;
	//��������
	public String selectUpwd(String uid) throws Exception;
	//�û�ͷ���ȡ
	public String selectUimage(String uid) throws Exception;
	//�޸�����
	public void updateUpwd(String uid, String upwd) throws Exception;
	//�û�����ҳ
	public List<User> PagingQuery(int offset, int count) throws Exception;
	//��ȡ�û���������
	public int allRows() throws Exception;
	//��ȡ��̨�����û��˺�
	public List<String> selectAllUid() throws Exception;
	//��ȡ�����û���Ϣ
	public List<User> selectUserInforById(String uid) throws Exception;
	//ɾ���û�
	public void deleteUser(String uid) throws Exception;
	//�޸ĵ�ַ
	public void updateUaddress(String uid, String uaddress) throws Exception;
	//�޸���ϵ��ʽ
	public void updateUtel(String uid, String utel) throws Exception;
	//�޸ĳ�ͷ���������Ϣ
	public void updateInfo(String uid, String uname, String uaddress, String ugender, String uage, String utel) throws Exception;
	//�˳���¼
	public void logout(HttpSession session) throws Exception;
	//���ӵ����ﳵ
	public void insertShopCart(String sid, String uid, String shopQuantity) throws Exception;
	//�鿴���ﳵ����ҳ
	public List<ShopCartDetail> selectCart(String uid) throws Exception;
	//���ӹ��ﳵ��Ʒ����
	public void updateShopQuantity(String uid, String sid, String shopQuantity) throws Exception;
	//���ﳵ��Ʒ�ܼ����
	public String selectSumPrice(String uid) throws Exception; 
	//��ȡ���ﳵ������
	public int shopCartAllRows(String uid) throws Exception;
	//���ﳵ�������ҳ
	public List<ShopCartDetail> ShopCartPagingQuery(int offset, int count, String uid) throws Exception;
	//ɾ�����ﳵ��Ʒ
	public void deleteShopInCart(String uid, String sid) throws Exception;
	//��ѯ�û����ж���
	public List<Orders> selectAllOrders(String uid) throws Exception;
	//��ȡ�û����ж���������
	public int userAllOrdersAllRows(String uid) throws Exception;
	//ɾ�����ﳵ��Ʒ
	public void deleteShopCart(String uid) throws Exception;
}