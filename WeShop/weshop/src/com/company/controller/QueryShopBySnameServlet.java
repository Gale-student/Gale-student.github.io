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

public class QueryShopBySnameServlet extends HttpServlet {

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
        String sname = request.getParameter("sname").trim();
		ManagerService managerService = new ManagerServiceImpl();
		String queryRes = "";
		try {
			List<Shop> shopList = managerService.queryShopBySname(sname, 0);
			int allRows = managerService.queryShopBySnameRows(sname);
			int allPage = allRows / 3;
			if(allRows % 3 != 0){
				allPage ++;
			}
			if(shopList.size() == 0){
				queryRes = "δ�鵽����Ʒ";
			}
			HttpSession hs = request.getSession();
			hs.setAttribute("allPage", allPage);
			hs.setAttribute("currentPage", 1);
			request.setAttribute("shopList", shopList);
			request.setAttribute("queryRes", queryRes);
			request.getRequestDispatcher("UpdateShoppingHomePage.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}