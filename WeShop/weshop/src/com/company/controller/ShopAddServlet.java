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

import com.company.entity.Shop;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ShopAddServlet extends HttpServlet {

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
			String sid = arr.get(0).getString("utf-8").trim();
			String sname = arr.get(1).getString("utf-8").trim();
			String stype = arr.get(2).getString("utf-8").trim();
			String scount = arr.get(3).getString("utf-8").trim();
			String sprice = arr.get(4).getString("utf-8").trim();
			FileItem image = arr.get(5);
			String simage = image.getName();
			ManagerService managerService = new ManagerServiceImpl();
			String msg = "";
			
			List<Shop> shopList;
			try {
				shopList = managerService.queryAllShop();
				for(Shop shop : shopList){
					String id = shop.getSid();
					if(id.equals(sid)){
						msg = "��ƷID�Ѵ���, ���ʧ��";
						break;
					}
				}
				if(msg.equals("��ƷID�Ѵ���, ���ʧ��")){
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("WEB-INF/jsp/ShopAdd.jsp").forward(request, response);
				}else{
					if(sname.equals("") || stype.equals("") || scount.equals("") || sprice.equals("") || simage.equals("")){
						msg = "�뽫��Ϣ��д����";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("WEB-INF/jsp/ShopAdd.jsp").forward(request, response);
					}else{
						managerService.addShop(sid, sname, stype, scount, sprice, simage);
						String path = "D:/image/shop/" + simage;
						File fPath = new File(path);
						image.write(fPath);
						msg = "�ϴ��ɹ�";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("WEB-INF/jsp/ShopAdd.jsp").forward(request, response);
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("sid: " + sid + " sname: " + sname + " stype: " + stype + " scount: " + scount + " sprice :" + sprice + simage);
			System.out.println("�յ������Ʒ��Ϊ");
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String msg = " �ϴ�ʧ��!��ƷͼƬ���ܹ��� ";
			System.out.println(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			String msg = "ͼƬδ�ϴ�";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("WEB-INF/jsp/ShopAdd.jsp").forward(request, response);
		}

	}

}
