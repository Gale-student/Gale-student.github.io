package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UserRegisterServlet extends HttpServlet {

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
		hs.removeAttribute("code");
		String uid = request.getParameter("uid").trim();
		String upwd = request.getParameter("upwd").trim();
		User user = new User();//��ʼ�����û�
		user.setUid(uid);
		user.setUpwd(upwd);
		UserService userService = new UserServiceImpl();
		try {
			userService.userRegister(user);//���û�ע��
			System.out.println("uid: " + uid + "   upwd: " + upwd);
			System.out.println("ע��ɹ�");
			response.sendRedirect("UserLogin.jsp");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("�������");
		}
		
	}

}