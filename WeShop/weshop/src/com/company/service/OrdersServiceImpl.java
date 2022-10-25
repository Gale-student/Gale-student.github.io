package com.company.service;

import java.util.List;

import com.company.dao.OrdersDao;
import com.company.dao.OrdersDaoImpl;
import com.company.entity.Orders;
import com.company.entity.OrdersDetail;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDao ordersDao = new OrdersDaoImpl();
	
    //��ȡ������������
	public int OrdersAllRows() throws Exception {
		int ordersAllRows = ordersDao.OrdersAllRows();
		return ordersAllRows;
	}
	
    //���Ӷ���(���� �µ� Ĭ��δ֧��״̬)
	public void addOrders(String oid, String uid, String sid, String quantity)
			throws Exception {
		ordersDao.insertOrders(oid, uid, sid, quantity);
	}
	
    //ȡ������
	public void cancelOrders(String oid) throws Exception {
		ordersDao.deleteOrders(oid);
	}
	
    //��������ҳ
	public List<Orders> ordersPagingQuery(int page) throws Exception {
		List<Orders> ordersList = ordersDao.ordersPaging(page * 3, 3);
		return ordersList;
	}
	
    //���ݶ�����Ų鶩��
	public List<Orders> queryOrdersByOid(String oid) throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByOid(oid);
		return ordersList;
	}
	
    //�鿴δ֧������
	public List<Orders> queryOrdersByStatusUnpaid() throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByStatusUnpaid();
		return ordersList;
	}
	
	//ͨ���û�ID�鶩��
	public List<Orders> queryOrdersByUid(String uid) throws Exception {
		List<Orders> ordersList = ordersDao.selectOrdersByUid(uid);
		return ordersList;
	}
	
	//�޸���Ʒ����
	public void modifyQuantity(String sid, String quantity) throws Exception {
		ordersDao.updateQuantity(sid, quantity);
	}
	
	//�������ж���
	public List<Orders> queryAllOrders() throws Exception {
		List<Orders> ordersList = ordersDao.selectAllOrders();
		return ordersList;
	}
	
	//�鿴�û����ж�������
	public List<OrdersDetail> selectOrdersDetail(String uid, int page) throws Exception {
		List<OrdersDetail> ordersDetailList = ordersDao.selectOrdersDetail(uid, page * 3, 3);
		return ordersDetailList;
	}
    
	//��ȡ�û�������������
	public int OrdersDetailAllRows(String uid) throws Exception {
		int ordersDetailAllRows = ordersDao.OrdersDetailAllRows(uid);
		return ordersDetailAllRows;
	}

	//��ȡ�û�δ֧������������
	public int OrdersDetailUnpaidAllRows(String uid) throws Exception {
		int ordersDetailUnpaidAllRows = ordersDao.OrdersDetailUnpaidAllRows(uid);
		return ordersDetailUnpaidAllRows;
	}

	//�鿴�û�δ֧����������
	public List<OrdersDetail> queryOrdersDetailUnpaid(String uid, int page) throws Exception {
		List<OrdersDetail> ordersDetaiUnpaidlList = ordersDao.selectOrdersDetailUnpaid(uid, page * 3, 3);
		return ordersDetaiUnpaidlList;
	}

	//
	public String queryTotalPriceOfUserUnpaidOrders(String uid)
			throws Exception {
		String totalPrice = ordersDao.selectTotalPriceOfUserUnpaidOrders(uid);
		return totalPrice;
	}

	public String queryOneOrdersTotalPrice(String uid, String oid)
			throws Exception {
		String totalPrice = ordersDao.selectOneOrdersTotalPrice(uid, oid);
		return totalPrice;
	}

	public void modifyOrdersStatus(String oid) throws Exception {
		ordersDao.updateOrdersStatus(oid);
		
	}

	public List<OrdersDetail> queryPaidOrdersDetail(String uid, int page)
			throws Exception {
		List<OrdersDetail> ordersDetaiPaidlList = ordersDao.selectPaidOrdersDetail(uid, page * 3, 3);
		return ordersDetaiPaidlList;
	}

	public int queryPaidOrdersRows(String uid) throws Exception {
		int rows = ordersDao.selectPaidOrdersRows(uid);
		return rows;
	}


}