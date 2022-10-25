<%@ page language="java" import="java.util.*, com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看所有用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/ManagerHomePage.css">
   <% 
      String res = (String) request.getAttribute("res");
      if(res == null){
         res = "";
      }
      String delRes = (String) request.getAttribute("delRes");
      if(delRes == null){
         delRes = "";
      }
      String upwdModifyRes = (String) request.getAttribute("upwdModifyRes");
      if(upwdModifyRes == null){
         upwdModifyRes = "";
      }
      String uaddressModifyRes = (String) request.getAttribute("uaddressModifyRes");
      if(uaddressModifyRes == null){
         uaddressModifyRes = "";
      }
      String utelModifyRes = (String) request.getAttribute("utelModifyRes");
      if(utelModifyRes == null){
         utelModifyRes = "";
      }
      
      String mname = (String)session.getAttribute("mname");
      List<User> userList = (List<User>) request.getAttribute("userList");
      int currentPage = (Integer) session.getAttribute("currentPage");
      String up = "上一页";
      if(currentPage == 1){
         up = "首页";
      }
      request.setAttribute("up", up);
      int allPage = (Integer) session.getAttribute("allPage");
      String down = "下一页";
      if(currentPage == allPage){
          down = "尾页";
      }
      request.setAttribute("down", down);
    %>
    <style type="text/css">
       #tablehead{
          font-weight: bolder;
       }
       #up{
          position: absolute;
          left:400px;
          top: 400px;
       }
       #down{
          position: absolute;
          left:510px;
          top: 400px;
       }
       #head{
          width: 50px;
          height: 50px;
       }
       table{
          position: absolute;
          left: 300px;
          top: 200px;
          table-layout: fixed;
          text-align: center;
       }
       td{
          width: 110px;
       }
       th{
          width: 110px;
       }
    </style>
  </head>
  
  <body>
  <!-- 顶部栏 -->
    <div class="topBar">
        <div class="container">
            <div class="topBar_list">
                <b>欢迎<%=mname %>管理员</b>
                
            </div>
            <div class="login">
                <a href="UserLogin.jsp"></a>
                <img src="/limage/site_logo1.png" style="margin-top: -25px">
            </div>
        </div>
    </div>
    <!-- 侧部栏 -->
    <div class="sideBar">
        <ul id="shopManager">
            <li class="main_nav"><a href="ShopPagingQueryServlet?url=WEB-INF/jsp/ShopQuery.jsp" target="mainFrame">商品管理</a></li>
		    <li class="main_nav"><a href="OrdersPagingQueryServlet?url=WEB-INF/jsp/OrdersQuery.jsp">订单管理</a></li>
		    <li class="main_nav"><a href="PagingQueryServlet?url=WEB-INF/jsp/PagingQueryServlet">用户管理</a></li>
			<li class="main_nav">
			    <a href="ManagerLogin.jsp"  target="_parent">退出</a>
			</li>
	    </ul>
    </div>
    <form style="position:absolute; left: 300px; top: 60px;" action="UserQueryOneServlet" method="post">
       <input type="text" placeholder="请输入用户ID" name="uid">
       <input type="submit" value="搜索">
    </form>
    
    <form style="position:absolute; left: 550px; top: 60px;" action="UserDeleteServlet" method="post">
       <input type="text" placeholder="请输入用户ID" name="uid">
       <input type="submit" value="删除"><label style="color: red;"><%=delRes %></label>
    </form>
    
     <form style="position:absolute; left: 300px; top: 90px;" action="ResetUserUpwdServlet" method="post">
       <input type="text" placeholder="请输入用户ID" name="uid">
       <input type="password" placeholder="请输入重置后的密码" name="upwd">
       <input type="submit" value="用户密码重置"><label style="color: red;"><%=upwdModifyRes %></label>
    </form>
    <form style="position:absolute; left: 300px; top: 120px;" action="UserModifyUaddressServlet" method="post">
       <input type="text" placeholder="请输入用户ID" name="uid">
       <input type="text" placeholder="请输入新的地址" name="uaddress">
       <input type="submit" value="修改用户地址"><label style="color: red;"><%=uaddressModifyRes %></label>
    </form>
    <form style="position:absolute; left: 300px; top: 150px;" action="UserModifyUtelServlet" method="post">
       <input type="text" placeholder="请输入用户ID" name="uid">
       <input type="text" placeholder="请输入新的联系方式" name="utel">
       <input type="submit" value="修改用户联系方式"><label style="color: red;"><%=utelModifyRes %></label>
    </form>
    <table border="2" cellspacing="0" >
       <tr id="tablehead">
          <th>用户ID</th>
          <th>用户密码</th>
          <th>姓名</th>
          <th>地址</th>
          <th>性别</th>
          <th>年龄</th>
          <th>联系方式</th>
          <th>头像</th>
       </tr>
       <c:forEach items="${userList}" var="user">
          <tr>
             <td><c:out value="${user.uid}"></c:out></td>
             <td><c:out value="${user.upwd}"></c:out></td>
             <td><c:out value="${user.uname}"></c:out></td>
             <td><c:out value="${user.uaddress}"></c:out></td>
             <td><c:out value="${user.ugender}"></c:out></td>
             <td><c:out value="${user.uage}"></c:out></td>
             <td><c:out value="${user.utel}"></c:out></td>
             <td>
                <img id="head" src="/himage/${user.uimage}">
             </td>
          </tr>
       </c:forEach>
    </table>
    <label style="position: absolute; left: 300; top: 240; color: red;"><%=res %></label>
    <form id="up" action="UpPageInfoServlet" method="post">
       <input type="submit" value="${up}">
       <label><c:out value="${currentPage} / ${allPage}"></c:out></label>
    </form>
    <form id="down" action="DownPageInfoServlet" method="post">
       <input type="submit" value="${down}">
    </form>
  </body>
</html>