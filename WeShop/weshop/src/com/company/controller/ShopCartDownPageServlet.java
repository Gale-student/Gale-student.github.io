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
import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class ShopCartDownPageServlet extends HttpServlet {

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
		String uid = (String)hs.getAttribute("uid");
		int currentPage = (Integer) hs.getAttribute("currentPage");
		int allPage = (Integer) hs.getAttribute("allPage");
		UserService userService = new UserServiceImpl();
		
		if(currentPage >= allPage){//���һҳ
			try {
				
				List<ShopCartDetail> shopCartDetailList = userService.ShopCartPagingQuery(currentPage - 1, uid);
				request.setAttribute("shopCartDetailList", shopCartDetailList);
				request.getRequestDispatcher("WEB-INF/jsp/ShopCart.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				List<ShopCartDetail> shopCartDetailList = userService.ShopCartPagingQuery(currentPage, uid);
				hs.setAttribute("currentPage", currentPage + 1);
				request.setAttribute("shopCartDetailList", shopCartDetailList);
				System.out.println(currentPage + " / " + allPage);
				request.getRequestDispatcher("WEB-INF/jsp/ShopCart.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
