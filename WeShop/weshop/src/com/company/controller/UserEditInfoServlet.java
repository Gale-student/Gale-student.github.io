package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UserEditInfoServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userService = new UserServiceImpl();
		String uid = request.getParameter("uid").trim();
		String uname = request.getParameter("uname").trim();
		String uaddress = request.getParameter("uaddress").trim();
		String ugender = request.getParameter("ugender").trim();
		String uage = request.getParameter("uage").trim();
		String utel = request.getParameter("utel").trim();
		String regex = "[1][3,5,6,7,8,9][0-9]{9}";
		String editRes = "";
		if(utel.matches(regex) == true){
			System.out.println("start");
			System.out.println("uname: " + uname);
			System.out.println("end");
			if(uname.equals("") || uaddress.equals("") || ugender.equals("") || uage.equals("") || utel.equals("")){
				editRes = "请将信息填写完整!";
				request.setAttribute("editRes", editRes);
				request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
			}else{
				try {
					userService.editInfo(uid, uname, uaddress, ugender, uage, utel);
					editRes = "修改成功";
					request.setAttribute("editRes", editRes);
					request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					editRes = "网络错误,修改失败";
					request.setAttribute("editRes", editRes);
					request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
				}
			}
			
		}else{
			editRes = "请输入正确的手机号";
			request.setAttribute("editRes", editRes);
			request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
		}
		
	}

}
