package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.entity.Shop;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ShopPagingQueryServlet extends HttpServlet {

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
		
		ManagerService managerService = new ManagerServiceImpl();
		//List<Shop> shopList;
		try {
			//shopList = managerService.queryAllShop();
			List<Shop> shopList = managerService.PagingQuery(0);
			int allRows = managerService.AllRows();
			int shopAllPage = allRows / 3;
			if(allRows % 3 != 0){
				shopAllPage ++;
			}
			HttpSession hs = request.getSession();
			hs.setAttribute("shopAllPage", shopAllPage);
			hs.setAttribute("shopCurrentPage", 1);
			request.setAttribute("shopList", shopList);
			
			String delres = (String)request.getAttribute("delres");
			request.setAttribute("delres", delres);
			
			String scountUpdateRes = (String)request.getAttribute("scountUpdateRes");
			request.setAttribute("scountUpdateRes", scountUpdateRes);
			
			String spriceUpdateRes = (String)request.getAttribute("spriceUpdateRes");
			request.setAttribute("spriceUpdateRes", spriceUpdateRes);
			
			String simageUpdateRes = (String)request.getAttribute("simageUpdateRes");
			request.setAttribute("simageUpdateRes", simageUpdateRes);
			
			System.out.println("res: " + simageUpdateRes);
			request.getRequestDispatcher("WEB-INF/jsp/ShopQuery.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
