package com.company.service;

import java.util.List;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;
import com.company.entity.User;

public interface OrdersService {
	//ɾ������(ȡ������)
	public void cancelOrders(String oid) throws Exception;
	//��ҳ
	public List<Orders> ordersPagingQuery(int page) throws Exception;
	//��ȡ������������
	public int OrdersAllRows() throws Exception;
	//���ݶ����Ų��Ҷ���
	public List<Orders> queryOrdersByOid(String oid) throws Exception;
	//�鿴δ֧������
	public List<Orders> queryOrdersByStatusUnpaid() throws Exception;
	//�û��µ�(���Ӷ���)
	public void addOrders(String oid, String uid, String sid, String quantity) throws Exception;
	//�����û�ID�鶩��
	public List<Orders> queryOrdersByUid(String uid) throws Exception;
	//���¶�������Ʒ����
	public void modifyQuantity(String sid, String quantity) throws Exception;
	//��Ѱ���ж���
	public List<Orders> queryAllOrders() throws Exception;
	//�����������ҳ(�û�)
	public List<OrdersDetail> selectOrdersDetail(String uid, int page) throws Exception;
	//��ȡ�û�������������
	public int OrdersDetailAllRows(String uid) throws Exception;
	//�û�δ֧��������ҳ��ѯ
	public List<OrdersDetail> queryOrdersDetailUnpaid(String uid, int page) throws Exception;
	//��ȡ�û�δ֧��������������
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception;
	//��ȡ����δ֧���������ܼ�
	public String queryTotalPriceOfUserUnpaidOrders(String uid) throws Exception;
	//��ȡ�����������ܼ�
	public String queryOneOrdersTotalPrice(String uid, String oid) throws Exception;
	//�޸Ķ���״̬
	public void modifyOrdersStatus(String oid) throws Exception;
	//�鿴��֧������
	public List<OrdersDetail> queryPaidOrdersDetail(String uid, int page) throws Exception;
	//��ȡ�û���֧��������������
	public int queryPaidOrdersRows(String uid) throws Exception;
}