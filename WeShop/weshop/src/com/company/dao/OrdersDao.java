package com.company.dao;

import java.util.List;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;

public interface OrdersDao {
	//ɾ������(ȡ������)
	public void deleteOrders(String oid) throws Exception;
	//��������ҳ
	public List<Orders> ordersPaging(int offset, int count) throws Exception;
	//��ȡ������������
	public int OrdersAllRows() throws Exception;
	//���ݶ����Ų��Ҷ���
	public List<Orders> selectOrdersByOid(String oid) throws Exception;
	//�鿴δ֧������
	public List<Orders> selectOrdersByStatusUnpaid() throws Exception;
	//�û��µ�(���Ӷ���)
	public void insertOrders(String oid, String uid, String sid, String quantity) throws Exception;
	//�����û�ID�鶩��
	public List<Orders> selectOrdersByUid(String uid) throws Exception;
	//���¶�������Ʒ����
	public void updateQuantity(String sid, String quantity) throws Exception;
	//��Ѱ���ж���
	public List<Orders> selectAllOrders() throws Exception;
	//�����������ҳ(�û�)
	public List<OrdersDetail> selectOrdersDetail(String uid, int offset, int count) throws Exception;
	//��ȡ�û�������������
	public int OrdersDetailAllRows(String uid) throws Exception;
	//�û�δ֧��������ҳ��ѯ
	public List<OrdersDetail> selectOrdersDetailUnpaid(String uid, int offset, int count) throws Exception;
	//��ȡ�û�δ֧��������������
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception;
	//��ȡ����δ֧���������ܼ�
	public String selectTotalPriceOfUserUnpaidOrders(String uid) throws Exception;
	//��ȡ�����������ܼ�
	public String selectOneOrdersTotalPrice(String uid, String oid) throws Exception;
	//�޸Ķ���״̬
	public void updateOrdersStatus(String oid) throws Exception;
	//�鿴�û���֧������
	public List<OrdersDetail> selectPaidOrdersDetail(String uid, int offset, int count) throws Exception;
	//��ȡ�û���֧��������������
	public int selectPaidOrdersRows(String uid) throws Exception;
}