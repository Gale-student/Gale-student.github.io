package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UpPageInfoServlet extends HttpServlet {

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
		try {
			UserService userService = new UserServiceImpl();
			HttpSession hs = request.getSession();
			int currentPage = (Integer) hs.getAttribute("currentPage");
			   if(currentPage <= 1 ){//Ê×Ò³
			      List<User> userList = userService.PagingQuery(0);
			      hs.setAttribute("currentPage", currentPage);
			      request.setAttribute("userList", userList);
			      request.getRequestDispatcher("WEB-INF/jsp/PagingQuery.jsp").forward(request, response);
			   }else{
				  List<User> userList = userService.PagingQuery(currentPage - 2);
				  hs.setAttribute("currentPage", currentPage - 1);
				  request.setAttribute("userList", userList);
				  request.getRequestDispatcher("WEB-INF/jsp/PagingQuery.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
