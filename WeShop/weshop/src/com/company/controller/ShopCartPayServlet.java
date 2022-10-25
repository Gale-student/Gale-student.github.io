package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.ShopCartDetail;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class ShopCartPayServlet extends HttpServlet {

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

		HttpSession hs = request.getSession();
		String uid = (String) hs.getAttribute("uid");
		UserService userService = new UserServiceImpl();
		String oid = "" + System.currentTimeMillis() + uid.subSequence(7, 11);
		try {
			List<ShopCartDetail> shopCartList = userService.quaryCart(uid);
			ManagerService managerService = new ManagerServiceImpl();
			OrdersService ordersService = new OrdersServiceImpl();
			for(ShopCartDetail shopCartDetail : shopCartList){
				String sid = shopCartDetail.getSid();
				String quantity = shopCartDetail.getShopQuantity();
				ordersService.addOrders(oid, uid, sid, quantity);
				managerService.modifyScount(sid, quantity);
					
			}
			//�Ƴ����ﳵ��Ʒ
			userService.removeShopCart(uid);
			String totalPrice = ordersService.queryOneOrdersTotalPrice(uid, oid);
			request.setAttribute("oid", oid);
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
