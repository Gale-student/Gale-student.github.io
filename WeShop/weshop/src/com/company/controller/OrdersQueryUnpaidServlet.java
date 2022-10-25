package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Orders;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;

public class OrdersQueryUnpaidServlet extends HttpServlet {

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

		OrdersService ordersService = new OrdersServiceImpl();
		try {
			List<Orders> ordersList = ordersService.queryOrdersByStatusUnpaid();
			System.out.println(ordersList);
			String unpaidOrders = "";
			if(ordersList.size() == 0){
				unpaidOrders = "������ȫ�����֧��";
			}
			request.setAttribute("unpaidOrders", unpaidOrders);
			request.setAttribute("ordersList", ordersList);
			request.getRequestDispatcher("WEB-INF/jsp/OrdersQuery.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}