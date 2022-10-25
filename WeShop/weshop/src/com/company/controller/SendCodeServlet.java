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

public class SendCodeServlet extends HttpServlet {

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
		int a = (int)(Math.random()* (10 - 1) + 1);
		int b = (int)(Math.random()* (10 - 1) + 1);
		int c = (int)(Math.random()* (10 - 1) + 1);
		int d = (int)(Math.random()* (10 - 1) + 1);
		int e = (int)(Math.random()* (10 - 1) + 1);
		int f = (int)(Math.random()* (10 - 1) + 1);
		String code = "" + a + b + c + d + e + f;
		HttpClient client = new HttpClient();
    	PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");    		                                                                                                                               post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = { new NameValuePair("Uid", "guohonglei"),
                new NameValuePair("Key", "21C3DDB647F374AE948754C08282E9F6"),
                new NameValuePair("smsMob", uid),
                new NameValuePair("smsText", "验证码：" + code) };//短信内容
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result); // 斜体内容为打印返回消息状态，无需要可删除
        post.releaseConnection();//释放连接
        
        HttpSession hs = request.getSession();
        hs.setAttribute("code", code);
        PrintWriter pw = response.getWriter();
		pw.write(code);
		pw.close();

	}

}
