package com.company.service;
/**
 * 
 * @author 86180
 * ����Աʵ����
 */
import java.util.List;

import com.company.dao.ManagerDao;
import com.company.dao.ManagerDaoImpl;
import com.company.entity.Shop;
import com.company.entity.User;


public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    
  //����Ա��¼
	public String ManagerLogin(String mid, String mpwd) throws Exception {
		String pwd = managerDao.selectMpwd(mid);
		if(pwd.equals("") || pwd == null){
			return "not exists!";
		}
		if(pwd.equals(mpwd)){
			return "success";
		}
		return "mpwd is wrong";
	}

	//������Ʒ
	public String addShop(String sid, String sname, String stype, String scount,
		String sprice, String simage) throws Exception {
		int res = managerDao.addShop(sid, sname, stype, scount, sprice, simage);
		if(res != 0){
			return "success";
		}else{
			return "false";
		}
		
	}

	//ɾ����Ʒ
	public void removeShop(String sid) throws Exception {
		managerDao.deleteShop(sid);
		
	}

	//������Ʒ���
	public void modifyShopScount(String sid, String scount) throws Exception {
		managerDao.updateShopScount(sid, scount);
		
	}

	//�޸���ƷͼƬ
	public void modifyShopSimage(String sid, String simage) throws Exception {
		managerDao.updateShopSimage(sid, simage);
		
	}

	//�޸���Ʒ�۸�
	public void modifyShopSprice(String sid, String sprice) throws Exception {
		managerDao.updateShopSprice(sid, sprice);
		
	}

	//�鿴������Ʒ
	public List<Shop> queryAllShop() throws Exception {
		List<Shop> shopList = managerDao.selectAllShop();
		return shopList;
	}

	//�鿴������Ʒ
	public List<Shop> queryOneShop(String sid) throws Exception {
		List<Shop> shopList = managerDao.selectOneShop(sid);
		return shopList;
	}

	//��ȡ����Ա����
	public String getManagerName(String mid) throws Exception {
		String mname = managerDao.selectMname(mid);
		return mname;
	}

	//��ȡ��Ʒ��������
	public int AllRows() throws Exception {
		int rows = managerDao.allRows();
		return rows;
	}

	//��Ʒ����ҳ
	public List<Shop> PagingQuery(int page) throws Exception {
		List<Shop> shopList = managerDao.PagingQuery(page * 3, 3);
		return shopList;
	}

	//��Ʒ������(�û��µ�)
	public void modifyScount(String sid, String quantity) throws Exception {
		managerDao.updateScount(sid, quantity);
		
	}

	//��Ʒ�������(�û�ȡ������)
	public void modifyRebackScount(String sid, String quantity)
			throws Exception {
		managerDao.updateRebackScount(sid, quantity);
		
	}
    
	//������Ʒ��������Ʒ
	public List<Shop> queryShopBySname(String sname, int page) throws Exception {
		List<Shop> shopList = managerDao.selectShopBySname(sname, page * 3, 3);
		return shopList;
	}

	//��ȡ������Ʒ��������Ʒ��������
	public int queryShopBySnameRows(String sname) throws Exception {
		int rows = managerDao.selectShopBySnameRows(sname);
		return rows;
	}

}