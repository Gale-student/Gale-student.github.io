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

public class ShopCartViewServlet extends HttpServlet {

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
		UserService userService = new UserServiceImpl();
		try {
			if(uid == null){
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}else{
				List<ShopCartDetail> shopCartDetailList = userService.quaryCart(uid);
				request.setAttribute("shopCartDetailList", shopCartDetailList);
				String totalPrice = userService.SumPrice(uid);
				request.setAttribute("totalPrice", totalPrice);
				String delRes = (String) request.getAttribute("delRes");
				request.setAttribute("delRes", delRes);
				request.getRequestDispatcher("WEB-INF/jsp/ShopCart.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
