package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Orders;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;

public class OrdersCancelOfUserServlet extends HttpServlet {

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

		
		String oid = request.getParameter("oid").trim();
		OrdersService ordersService = new OrdersServiceImpl();
		ManagerService managerService = new ManagerServiceImpl();
		try {
			
			List<Orders> ordersList = ordersService.queryOrdersByOid(oid);
			for(Orders orders : ordersList){
				String sid = orders.getSid();
				String quantity = orders.getQuantity();
				managerService.modifyRebackScount(sid, quantity);
				System.out.println("sid: " + sid + " quantity: " + quantity);
			}
			ordersService.cancelOrders(oid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("OrdersDetailUnpaidQueryServlet").forward(request, response);
	}

}
