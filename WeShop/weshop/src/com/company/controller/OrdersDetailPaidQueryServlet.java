package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.OrdersDetail;
import com.company.service.OrdersService;
import com.company.service.OrdersServiceImpl;

public class OrdersDetailPaidQueryServlet extends HttpServlet {

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
		OrdersService ordersService = new OrdersServiceImpl();
		try {
			List<OrdersDetail> ordersDetailList = ordersService.queryPaidOrdersDetail(uid, 0);
			int allRows = ordersService.queryPaidOrdersRows(uid);
			int allPage = allRows / 3;
			if(allRows % 3 != 0){
				allPage ++;
			}
			hs.setAttribute("allPage", allPage);
			hs.setAttribute("currentPage", 1);
			request.setAttribute("ordersDetailList", ordersDetailList);
			request.getRequestDispatcher("WEB-INF/jsp/OrdersPaidQueryOfUser.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
