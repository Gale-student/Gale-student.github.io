package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ManagerLoginServlet extends HttpServlet {

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
	 * ����Ա��¼
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String mid = request.getParameter("mid").trim();
        String mpwd = request.getParameter("mpwd").trim();
        Cookie c1 = new Cookie("mid", mid);
        Cookie c2 = new Cookie("mpwd", mpwd);
        c1.setMaxAge(24 * 60 * 60 * 1000);
        c2.setMaxAge(24 * 60 * 60 * 1000);
        response.addCookie(c1);
        response.addCookie(c2);
		ManagerService managerService = new ManagerServiceImpl();
		String res = "";
		try {
			String msg = managerService.ManagerLogin(mid, mpwd);
			if(msg.equals("success")){
				String mname = managerService.getManagerName(mid);
				HttpSession hs = request.getSession();
				hs.setAttribute("mname", mname);
				request.getRequestDispatcher("ShopPagingQueryServlet").forward(request, response);
			}else if(msg.equals("not exists!")){
				res = "�˺Ŵ���";
				request.setAttribute("res", res);
				request.getRequestDispatcher("ManagerLogin.jsp").forward(request, response);
			}else{
				res = "�������";
				request.setAttribute("res", res);
				request.getRequestDispatcher("ManagerLogin.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
