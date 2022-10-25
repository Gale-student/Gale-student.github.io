package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class DeleteShopInCartServlet extends HttpServlet {

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
	 * 删除购物车中的商品
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
		String sid = request.getParameter("sid").trim();
		String quantity = request.getParameter("quantity").trim();
		String delRes = "";
		UserService userService = new UserServiceImpl();
		ManagerService managerService = new ManagerServiceImpl();
		try {
			userService.deleteShopInCart(uid, sid);
			delRes = "删除成功";
			managerService.modifyRebackScount(sid, quantity);
			request.setAttribute("delRes", delRes);
			request.getRequestDispatcher("ShopCartViewServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
