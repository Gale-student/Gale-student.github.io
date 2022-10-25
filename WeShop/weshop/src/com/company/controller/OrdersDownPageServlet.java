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
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;

public class OrdersDownPageServlet extends HttpServlet {

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
	 * ������ִ����һҳ
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
			HttpSession hs = request.getSession();
			int ordersCurrentPage = (Integer) hs.getAttribute("ordersCurrentPage");
			int ordersAllPage = (Integer) hs.getAttribute("ordersAllPage");
			if(ordersCurrentPage >= ordersAllPage ){//���һҳ
			      List<Orders> ordersList = ordersService.ordersPagingQuery(ordersCurrentPage - 1);
			      hs.setAttribute("ordersCurrentPage", ordersCurrentPage);
			      request.setAttribute("ordersList", ordersList);
			      request.getRequestDispatcher("WEB-INF/jsp/OrdersQuery.jsp").forward(request, response);
			      
			   }else{
				  List<Orders> ordersList = ordersService.ordersPagingQuery(ordersCurrentPage);
				  hs.setAttribute("ordersCurrentPage", ordersCurrentPage + 1);
				  request.setAttribute("ordersList", ordersList);
				  System.out.println(ordersCurrentPage + " / " + ordersAllPage);
				  request.getRequestDispatcher("WEB-INF/jsp/OrdersQuery.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}