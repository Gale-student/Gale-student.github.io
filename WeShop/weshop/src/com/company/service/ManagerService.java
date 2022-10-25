package com.company.service;

import java.util.List;

import com.company.entity.Shop;
import com.company.entity.User;

public interface ManagerService {
	//����Ա��¼
	public String ManagerLogin(String mid, String mpwd) throws Exception;
	//��ȡ����Ա����
	public String getManagerName(String mid) throws Exception;
	//��Ʒ���� 
	public String addShop(String sid, String sname, String stype, String scount, String sprice, String simage) throws Exception;
	//ɾ����Ʒ
	public void removeShop(String sid) throws Exception;
	//�޸���Ʒ�۸�
	public void modifyShopSprice(String sid, String sprice) throws Exception;
	//�޸���Ʒ���
	public void modifyShopScount(String sid, String scount) throws Exception;
	//�޸���ƷͼƬ
	public void modifyShopSimage(String sid, String simage) throws Exception;
	//�鿴������Ʒ
	public List<Shop> queryOneShop(String sid) throws Exception;
	//�鿴������Ʒ
	public List<Shop> queryAllShop() throws Exception;
	//��ҳ
	public List<Shop> PagingQuery(int page) throws Exception;
	//��ȡ����
	public int AllRows() throws Exception;
	//��Ʒ������(�û��µ�)
	public void modifyScount(String sid, String quantity) throws Exception;
	//��Ʒ�������(�û�ȡ������)
	public void modifyRebackScount(String sid, String quantity) throws Exception;
	//������Ʒ��������Ʒ
	public List<Shop> queryShopBySname(String sname, int page) throws Exception;
	//��ȡ������Ʒ��������Ʒ��������
	public int queryShopBySnameRows(String sname) throws Exception;
	
}