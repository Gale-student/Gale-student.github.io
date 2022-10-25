<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息完善</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style type="text/css">
      body{
         background: url("image/3.jpg");
         background-size: cover;
      }
      #box{
         background: white;
         width: 500px;
         height: 500px;
         position:absolute;
         left: 500px;
         top: 50px;
         //border:2px solid red;
         border-radius: 5%;
         opacity: 0.88;
         text-align: center;
      }
      input{
         padding: 10px;
         margin:10px;
      }
      #l1{
         position: absolute;
         
         left: 115px;
      }
      #in1{
         position: absolute;
         top: 347px;
         left: 180px;
      }
   
   </style>
  </head>
     <% 
        String uid = (String)session.getAttribute("uid"); 
     %>
  
  <body>
  <div id = "box">
  <form action="UpdownPersonInfoServlet" method="post" enctype="multipart/form-data">
    <label>账 &nbsp;&nbsp;&nbsp;&nbsp;号：</label><input type="text" name="uid" value="<%=uid %>" readonly="readonly"><br>
    <label>姓 &nbsp;&nbsp;&nbsp;&nbsp;名：</label><input type="text" placeholder="请输入姓名" name="uname"/><br>
    <label>地 &nbsp;&nbsp;&nbsp;&nbsp;址：</label><input type="text" placeholder="请输入地址" name="uaddress"/><br>
    <label>性 &nbsp;&nbsp;&nbsp;&nbsp;别：</label><input type="text" placeholder="请输入性别" name="ugender"/><br>
    <label>年 &nbsp;&nbsp;&nbsp;&nbsp;龄：</label><input type="text" placeholder="请输入年龄" name="uage"/><br>
    <label>联系方式：</label><input type="text" placeholder="请输入联系方式" name="utel"><br>
    <label id="l1">头 &nbsp;&nbsp;&nbsp;&nbsp;像：</label><input id="in1" type="file" value="点击上传图片" name="uimage"><br><br>
    <input type="submit" value="提交个人信息并前往登录页面">
  </form>
  </div>
  </body>
</html>
