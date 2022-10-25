package com.company.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

public class UpdownPersonInfoServlet extends HttpServlet {

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
		
		DiskFileItemFactory factor = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factor);
		sfu.setFileSizeMax(10240 * 6000);
		try {
			List<FileItem> arr = sfu.parseRequest(request);
			String id = arr.get(0).getString("utf-8").trim();
			String uname = arr.get(1).getString("utf-8").trim();
			String uaddress = arr.get(2).getString("utf-8").trim();
			String ugender = arr.get(3).getString("utf-8").trim();
			String uage = arr.get(4).getString("utf-8").trim();
			String utel = arr.get(5).getString("utf-8").trim();
			FileItem image = arr.get(6);
			String name = image.getName();
			System.out.println("uname: " + uname);
			
			
			UserService userService = new UserServiceImpl();
			if(name.equals("") || name == null ){
				name = "default.jpg";
				try {
					userService.completePersonalInfo(id, uname, uaddress, ugender, uage, utel, name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				request.getRequestDispatcher("ShoppingHomePage.jsp").forward(request, response);

			}else{
				String path = "D:/image/head/" + name;
				File fPath = new File(path);
				image.write(fPath);
				userService.completePersonalInfo(id, uname, uaddress, ugender, uage, utel, name);
				request.getRequestDispatcher("ShoppingHomePage.jsp").forward(request, response);
			
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}