package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Shop;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ShopModifyScountServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String sid = request.getParameter("sid").trim();
        String scountUpdateRes = "商品ID不存在, 更新失败";
		ManagerService managerService = new ManagerServiceImpl();
        List<Shop> shopList;
		try {
			shopList = managerService.queryAllShop();
			for(int i = 0; i < shopList.size(); i ++){
				String id = shopList.get(i).getSid();
				if(id.equals(sid)){
					String scount = request.getParameter("scount").trim();
					if(scount.equals("")){
						scountUpdateRes = "请输入新的库存";
					}else{
						managerService.modifyShopScount(sid, scount);
						scountUpdateRes = sid + "库存更新成功";
						break;
					}
				}
			}
			request.setAttribute("scountUpdateRes", scountUpdateRes);
			request.getRequestDispatcher("ShopPagingQueryServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
