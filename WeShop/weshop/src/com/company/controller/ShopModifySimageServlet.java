package com.company.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.company.entity.Shop;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

public class ShopModifySimageServlet extends HttpServlet {

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
		String simageUpdateRes = "商品ID不存在, 更新失败";
		DiskFileItemFactory factor = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factor);
		sfu.setFileSizeMax(10240 * 6000);
		try {
			List<FileItem> arr = sfu.parseRequest(request);
			String sid = arr.get(0).getString();
			
			ManagerService managerService = new ManagerServiceImpl();
			List<Shop> shopList = managerService.queryAllShop();
			for(Shop shop : shopList){
				String id = shop.getSid();
				if(id.equals(sid)){
					FileItem image = arr.get(1);
					String simage = image.getName();
					String path = "D:/image/shop/" + simage;
					File file = new File(path);
					image.write(file);
					managerService.modifyShopSimage(sid, simage);
					simageUpdateRes = "更新成功";
					break;
				}
			}
			request.setAttribute("simageUpdateRes", simageUpdateRes);
			request.getRequestDispatcher("ShopPagingQueryServlet").forward(request, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			simageUpdateRes = "图片过大, 上传失败";
			request.setAttribute("simageUpdateRes", simageUpdateRes);
			request.getRequestDispatcher("ShopPagingQueryServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			simageUpdateRes = "更新失败";
			request.setAttribute("simageUpdateRes", simageUpdateRes);
			request.getRequestDispatcher("ShopPagingQueryServlet").forward(request, response);
		}
	}
}
