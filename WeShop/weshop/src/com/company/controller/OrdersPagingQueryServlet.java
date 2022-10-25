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
import com.company.entity.User;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class OrdersPagingQueryServlet extends HttpServlet {

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
	 * ∂©µ•±Ì∑÷“≥
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OrdersService ordersService = new OrdersServiceImpl();
			List<Orders> ordersList = ordersService.ordersPagingQuery(0);
			int ordersAllRows = ordersService.OrdersAllRows();
			int ordersAllPage = ordersAllRows / 3;
			if(ordersAllRows % 3 != 0){
				ordersAllPage ++;
			}
			HttpSession hs = request.getSession();
			hs.setAttribute("ordersAllPage", ordersAllPage);
			hs.setAttribute("ordersCurrentPage", 1);
			request.setAttribute("ordersList", ordersList);
			
			String ordersDelRes = (String)request.getAttribute("ordersDelRes");
			request.setAttribute("ordersDelRes", ordersDelRes);
			request.getRequestDispatcher("WEB-INF/jsp/OrdersQuery.jsp").forward(request, response);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

}
