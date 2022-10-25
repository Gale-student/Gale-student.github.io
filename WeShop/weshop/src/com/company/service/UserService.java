package com.company.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.ShopCartDetail;
import com.company.entity.User;

public interface UserService {
	//�û�ע��
	public void userRegister(User user) throws Exception;
    //���Ƹ�����Ϣ
	public void completePersonalInfo(String uid, String uname,String uaddress,String ugender,String uage,String utel, String uimage) throws Exception;
	//�û���¼name
	public String userLogin(String uid, String upwd) throws Exception;
	//�û�����ͷ��չʾ
	public String userImageDisplay(String uid) throws Exception;
	//�޸�����
	public void modifyUserUpwd(String uid, String upwd) throws Exception;
	//��ҳ
	public List<User> PagingQuery(int page) throws Exception;
	//��ȡ����
	public int AllRows() throws Exception;
	//��ȡ��̨�����û��˺�
	public List<String> queryAllUid() throws Exception;
	//��ȡ�û���Ϣ
	public List<User> queryUserInfo(String uid) throws Exception;
	//�û�ע��
	public void deleteUser(String uid) throws Exception;
	//�޸ĵ�ַ
	public void modifyUserUaddress(String uid, String uaddress) throws Exception;
	//�޸���ϵ��ʽ
	public void modifyUserUtel(String uid, String utel) throws Exception;
	//�˳���¼
	public void logout(HttpSession session) throws Exception;
	//�༭������Ϣ
	public void editInfo(String uid, String uname, String uaddress, String ugender, String uage, String utel) throws Exception;
	//��ӵ����ﳵ
	public void addShopCart(String sid, String uid, String shopQuantity) throws Exception;
	//�鿴���ﳵ����ҳ
	public List<ShopCartDetail> quaryCart(String uid) throws Exception;
	//���ӹ��ﳵ��Ʒ����
	public void addShopQuantity(String uid, String sid, String shopQuantity) throws Exception;
	//���ﳵ��Ʒ�ܼ����
	public String SumPrice(String uid) throws Exception; 
	//��ȡ���ﳵ������
	public int shopCartAllRows(String uid) throws Exception;
	//���ﳵ������ҳ
	public List<ShopCartDetail> ShopCartPagingQuery(int page, String uid) throws Exception;
	//ɾ�����ﳵ��Ʒ
	public void deleteShopInCart(String uid, String sid) throws Exception;
	//��ѯ�û����ж���
	public List<Orders> queryAllOrders(String uid) throws Exception;
	//ɾ�����ﳵ��Ʒ
	public void removeShopCart(String uid) throws Exception;
}
