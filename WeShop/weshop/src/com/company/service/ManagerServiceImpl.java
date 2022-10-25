package com.company.service;
/**
 * 
 * @author 86180
 * 管理员实现类
 */
import java.util.List;

import com.company.dao.ManagerDao;
import com.company.dao.ManagerDaoImpl;
import com.company.entity.Shop;
import com.company.entity.User;


public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    
  //管理员登录
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

	//添加商品
	public String addShop(String sid, String sname, String stype, String scount,
		String sprice, String simage) throws Exception {
		int res = managerDao.addShop(sid, sname, stype, scount, sprice, simage);
		if(res != 0){
			return "success";
		}else{
			return "false";
		}
		
	}

	//删除商品
	public void removeShop(String sid) throws Exception {
		managerDao.deleteShop(sid);
		
	}

	//更新商品库存
	public void modifyShopScount(String sid, String scount) throws Exception {
		managerDao.updateShopScount(sid, scount);
		
	}

	//修改商品图片
	public void modifyShopSimage(String sid, String simage) throws Exception {
		managerDao.updateShopSimage(sid, simage);
		
	}

	//修改商品价格
	public void modifyShopSprice(String sid, String sprice) throws Exception {
		managerDao.updateShopSprice(sid, sprice);
		
	}

	//查看所有商品
	public List<Shop> queryAllShop() throws Exception {
		List<Shop> shopList = managerDao.selectAllShop();
		return shopList;
	}

	//查看单个商品
	public List<Shop> queryOneShop(String sid) throws Exception {
		List<Shop> shopList = managerDao.selectOneShop(sid);
		return shopList;
	}

	//获取管理员名字
	public String getManagerName(String mid) throws Exception {
		String mname = managerDao.selectMname(mid);
		return mname;
	}

	//获取商品表总行数
	public int AllRows() throws Exception {
		int rows = managerDao.allRows();
		return rows;
	}

	//商品表分页
	public List<Shop> PagingQuery(int page) throws Exception {
		List<Shop> shopList = managerDao.PagingQuery(page * 3, 3);
		return shopList;
	}

	//商品库存减少(用户下单)
	public void modifyScount(String sid, String quantity) throws Exception {
		managerDao.updateScount(sid, quantity);
		
	}

	//商品库存增加(用户取消订单)
	public void modifyRebackScount(String sid, String quantity)
			throws Exception {
		managerDao.updateRebackScount(sid, quantity);
		
	}
    
	//根据商品名查找商品
	public List<Shop> queryShopBySname(String sname, int page) throws Exception {
		List<Shop> shopList = managerDao.selectShopBySname(sname, page * 3, 3);
		return shopList;
	}

	//获取根据商品名查找商品的总行数
	public int queryShopBySnameRows(String sname) throws Exception {
		int rows = managerDao.selectShopBySnameRows(sname);
		return rows;
	}

}
