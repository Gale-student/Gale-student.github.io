<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyPersonalInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <% 
      String msg = (String)request.getAttribute("msg");
      if(msg == null){
         msg = "";
      }
      String uid = (String)session.getAttribute("uid");
   %>
  </head>
  <body>
    <div>
       <form action="ModifyUserUpwdServlet" method="post">
          <label>*账号：</label><input type="text" value="<%=uid %>" name="uid" readonly="readonly">
          <input type="password" placeholder="请输入新的密码" name="upwd">
          <input type="submit" value="提交">
          <label><%=msg %></label>
       </form>
    </div>
  </body>
</html>
