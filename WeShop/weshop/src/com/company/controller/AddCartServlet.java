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
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class AddCartServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 添加购物车
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
		String sid = request.getParameter("sid").trim();
		String shopQuantity = request.getParameter("shopQuantity").trim();
		System.out.println(uid + ": " + sid + ": " + shopQuantity); 
		UserService userService = new UserServiceImpl();
		List<ShopCartDetail> shopCartDetailList;
		ManagerService managerService = new ManagerServiceImpl();
		
		try {
			shopCartDetailList = userService.quaryCart(uid);
			boolean flag = true;
			if(uid == null){
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}else{
				for(ShopCartDetail shopCartDetail : shopCartDetailList){
					if(shopCartDetail.getSid().equals(sid)){
						//增加数量(修改购物车商品数量)
						userService.addShopQuantity(uid, sid, shopQuantity);
						flag = false;
						managerService.modifyScount(sid, shopQuantity);
						request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
						break;
					}
				}
				if(flag == true){
					userService.addShopCart(sid, uid, shopQuantity);
					managerService.modifyScount(sid, shopQuantity);
					request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		 
		
	}

}
