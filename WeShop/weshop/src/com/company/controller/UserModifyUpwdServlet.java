package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UserModifyUpwdServlet extends HttpServlet {

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

		String oldUpwd = request.getParameter("oldUpwd").trim();
		String newUpwd = request.getParameter("newUpwd").trim();
		String regex = "[0-9]{6}";
		boolean res = newUpwd.matches(regex);
		String upwdModifyRes = "";
        UserService userService = new UserServiceImpl();
		try {
			String checkRes = userService.userLogin(uid, oldUpwd);
			System.out.println("checkRes: " + checkRes);
			if(checkRes.equals("µÇÂ¼³É¹¦")){
				if(res == true){
					userService.modifyUserUpwd(uid, newUpwd);
					upwdModifyRes = "ÐÞ¸Ä³É¹¦";
					System.out.println(upwdModifyRes);
				}else{
					upwdModifyRes = "ÃÜÂë¸ñÊ½´íÎó";
					System.out.println(upwdModifyRes);
				}
			}else if(checkRes.equals("ÃÜÂë´íÎó")){
				upwdModifyRes = "ÃÜÂë´íÎó";
				System.out.println(upwdModifyRes);
			}else{
				System.out.println(uid);
			}
			
			request.setAttribute("upwdModifyRes", upwdModifyRes);
			request.getRequestDispatcher("AaShoppingHomePageServlet").forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}

}
