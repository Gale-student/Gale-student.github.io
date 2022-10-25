package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UidCheckServlet extends HttpServlet {

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
		
		String uid = request.getParameter("uid");
		System.out.println(uid);
		String uidregex = "[1][3,4,5,7,8,9][0-9]{9}";
		boolean uidres = uid.matches(uidregex);
		String result = "";
		if(uidres == true){
			UserService userService = new UserServiceImpl();
			
			try {
				List<String> uidList = userService.queryAllUid();
				for(String item : uidList){
					if(uid.equals(item) == true){
						result = "exist";
						System.out.println(uid.equals(item));
					}
				}
				if(result == ""){
					result = "success";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			result = "error";
		}
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.close();
		
	}

}
