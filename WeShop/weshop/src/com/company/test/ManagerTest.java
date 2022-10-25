package com.company.test;

import com.company.dao.ManagerDao;
import com.company.dao.ManagerDaoImpl;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ManagerTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ManagerDao managerDao = new ManagerDaoImpl();
		ManagerService managerService = new ManagerServiceImpl();
//		String mpwd = managerDao.selectMpwd("admin");
//		System.out.println(mpwd);
		//managerDao.deleteShop("s103");
		//managerService.removeShop("s102");
//		managerService.modifyShopScount("s102", "12");
//		managerService.modifyShopSprice("s102", "1111");
//		managerService.modifyShopSimage("s102", "999");
		managerService.modifyScount("s103", "12");
	}

}
