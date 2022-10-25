package com.company.dao;

import java.util.List;

import com.company.entity.Shop;
import com.company.entity.User;

public interface ManagerDao {
	//��ȡ����
	public String selectMpwd(String mid) throws Exception;
	//��ȡ����Ա����
	public String selectMname(String mid) throws Exception;
	//������Ʒ
	public int addShop(String sid, String sname, String stype, String scount, String sprice, String simage) throws Exception;
	//ɾ����Ʒ
	public void deleteShop(String sid) throws Exception;
	//�޸���Ʒ�۸�
	public void updateShopSprice(String sid, String sprice) throws Exception;
	//�޸���Ʒ���
	public void updateShopScount(String sid, String scount) throws Exception;
	//�޸���ƷͼƬ
	public void updateShopSimage(String sid, String simage) throws Exception;
	//�鿴������Ʒ
	public List<Shop> selectOneShop(String sid) throws Exception;
	//�鿴������Ʒ
	public List<Shop> selectAllShop() throws Exception;
	//��Ʒ����ҳ
	public List<Shop> PagingQuery(int offset, int count) throws Exception;
	//��ȡ��Ʒ��������
	public int allRows() throws Exception;
	//��Ʒ������(�û��µ�)
	public void updateScount(String sid, String quantity) throws Exception;
	//��Ʒ�������(�û�ȡ������)
	public void updateRebackScount(String sid, String quantity) throws Exception;
	//������Ʒ��������Ʒ
	public List<Shop> selectShopBySname(String sname, int offset, int count) throws Exception;
	//��ȡ������Ʒ��������Ʒ��������
	public int selectShopBySnameRows(String sname) throws Exception;

}