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

public class ResetUserUpwdServlet extends HttpServlet {

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
		
		String upwdModifyRes = "�޸�ʧ��,�û�ID������";
		try {
			List<String> uidList = userService.queryAllUid();
			for(String id : uidList){
				if(id.equals(uid)){
					if(upwd.equals("")){
						upwdModifyRes = "�������µ�����";
						break;
					}else{
						upwdModifyRes = "�޸ĳɹ�";
						userService.modifyUserUpwd(uid, upwd);
						break;
					}
				}
			}
			request.setAttribute("upwdModifyRes", upwdModifyRes);
			request.getRequestDispatcher("PagingQueryServlet").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
			
		
	}

}