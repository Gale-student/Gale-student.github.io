package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {

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

		String uid = request.getParameter("uid").trim();
		String upwd = request.getParameter("upwd").trim();
		UserService userService = new UserServiceImpl();
		try {
			String res = userService.userLogin(uid, upwd);
			if(res.equals("��¼�ɹ�")){

				List<User> userList = userService.queryUserInfo(uid);
				String uname = userList.get(0).getUname();
				HttpSession hs = request.getSession();
				hs.setAttribute("uid", uid);

				Cookie c1 = new Cookie("uid", uid);
				Cookie c2 = new Cookie("upwd", upwd);
				c1.setMaxAge(24 * 60 * 60 * 1000);
			    c2.setMaxAge(24 * 60 * 60 * 1000);
				response.addCookie(c1);
				response.addCookie(c2);

				if(uname == null || uname.equals("")){
					request.getRequestDispatcher("WEB-INF/jsp/InfoComplete.jsp").forward(request, response);
				}else{
					//request.getRequestDispatcher("ShoppingHomePage.jsp").forward(request, response);
					request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
				}
				
			}else{
				request.setAttribute("res",res);
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			request.setAttribute("res","�������");
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}
	}

}
