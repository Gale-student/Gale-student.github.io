package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.Orders;
import com.company.entity.OrdersDetail;
import com.company.entity.Shop;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;

public class ShopBuyServlet extends HttpServlet {

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
		String sid = request.getParameter("sid").trim();
		String quantity = request.getParameter("quantity");
		
		if(uid == null){
			response.sendRedirect("UserLogin.jsp");	
		}else{
			OrdersService ordersService = new OrdersServiceImpl();
			try {
				String oid = "" + System.currentTimeMillis() + uid.subSequence(7, 11);
				ordersService.addOrders(oid, uid, sid, quantity);
				
				ManagerService managerService = new ManagerServiceImpl();
				managerService.modifyScount(sid, quantity);
				
				request.setAttribute("oid", oid);
				request.setAttribute("sid", sid);
				String totalPrice = ordersService.queryOneOrdersTotalPrice(uid, oid);
				request.setAttribute("totalPrice", totalPrice);
				request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
