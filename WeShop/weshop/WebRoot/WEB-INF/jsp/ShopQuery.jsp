<%@ page language="java" import="java.util.*, com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="content-type" content="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/ManagerHomePage.css">
  <%
     String mname = (String)session.getAttribute("mname");
     String delres = (String)request.getAttribute("delres");
     if(delres == null){
        delres = "";
     }
     String scountUpdateRes = (String)request.getAttribute("scountUpdateRes");
     if(scountUpdateRes == null){
        scountUpdateRes = "";
     }
     String spriceUpdateRes = (String)request.getAttribute("spriceUpdateRes");
     if(spriceUpdateRes == null){
        spriceUpdateRes = "";
     }
     String simageUpdateRes = (String)request.getAttribute("simageUpdateRes");
     if(simageUpdateRes == null){
        simageUpdateRes = "";
     }
     
     List<Shop> shopList = (List<Shop>)request.getAttribute("shopList");
     String msg = "";
     if(shopList.size() == 0){
         msg = "没有该商品";
         request.setAttribute("msg", msg);
     }
     int shopCurrentPage = (Integer) session.getAttribute("shopCurrentPage");
      String up = "上一页";
      if(shopCurrentPage == 1){
         up = "首页";
      }
      request.setAttribute("up", up);
      int shopAllPage = (Integer) session.getAttribute("shopAllPage");
      String down = "下一页";
      if(shopCurrentPage == shopAllPage){
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
          left:500px;
          top: 400px;
       }
       #down{
          position: absolute;
          left:610px;
          top: 400px;
       }
       #head{
          width: 50px;
          height: 50px;
       }
       table{
          position: absolute;
          left: 400px;
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
       #search{
           position: absolute;
           left: 400px;
           top: 50px;
       }
       img:hover{
           transform: scale(2);
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
		    <li class="main_nav"><a href="PagingQueryServlet?url=WEB-INF/jsp/PagingQuery.jsp">用户管理</a></li>
			<li class="main_nav">
			    <a href="ManagerLogin.jsp"  target="_parent">退出</a>
			</li>
	    </ul>
    </div>
    <div>
    
    <label style="position: absolute;color: red; margin-left: 400px; margin-top: 170px;"><%=msg %></label>
    <form id="search" action="ShopQueryOneServlet" method="post">
	    <input type="text" placeholder="请输入商品ID" name="sid">
	    <input type="submit" value="搜索">
    </form>
    
    <form style="position: absolute; left: 630px; top: 50px;" action="ShopRemoveServlet" method="post">
	    <input type="text" placeholder="请输入商品ID" name="sid">
	    <input type="submit" value="删除">
	    <label style="color: red;"><%=delres %></label>
    </form>
    <form action="ShopManagerServlet" method="post">
        <input style="position: absolute; left: 1000px; top: 50px;" type="submit" value="添加商品">
    </form>
    <form style="position: absolute; left: 400px; top: 80px;" action="ShopModifyScountServlet" method="post">
        <input type="text" placeholder="请输入商品ID" name="sid">
        <input type="text" placeholder="请输入新的库存量" name="scount">
        <input type="submit" value="更新库存"/><label style="color: red;"><%=scountUpdateRes %></label>
    </form>
    <form style="position: absolute; left: 400px; top: 110px;" action="ShopModifySpriceServlet" method="post">
        <input type="text" placeholder="请输入商品ID" name="sid">
        <input type="text" placeholder="请输入新的价格" name="sprice">
        <input type="submit" value="更新价格"/><label style="color: red;"><%=spriceUpdateRes %></label>
    </form>
    <form style="position: absolute; left: 400px; top: 140px;" action="ShopModifySimageServlet" method="post" enctype="multipart/form-data">
        <input type="text" placeholder="请输入商品ID" name="sid">
        <input type="file" name="simage">
        <input style="position: absolute; left: 350px;" type="submit" value="更新图片"/>
        <label style="margin-left: 20px;color: red; "><%=simageUpdateRes %></label>
    </form>
    <table border="2" cellspacing="2" >
       <tr id="tablehead">
          <th>商品ID</th>
          <th>商品名</th>
          <th>商品类型</th>
          <th>商品库存</th>
          <th>商品单价</th>
          <th>商品图片</th>
       </tr>
       <% for( int i = 0; i < shopList.size(); i ++){ %>
          <tr>
             <td><%=shopList.get(i).getSid()%></td>
             <td><%=shopList.get(i).getSname()%></td>
             <td><%=shopList.get(i).getStype()%></td>
             <td><%=shopList.get(i).getScount()%></td>
             <td><%=shopList.get(i).getSprice()%></td>
             <td>
                <img style="width: 40px; height: 40px;" src=<%="/simage/" + shopList.get(i).getSimage() %> >
             </td>
          </tr>
       <% } %>
    </table>
    
     <form id="up" action="ShopUpPageServlet" method="post">
       <input type="submit" value=<%=up %>>
       <label><%=shopCurrentPage + "/" + shopAllPage %></label>
    </form>
    <form id="down" action="ShopDownPageServlet" method="post">
       <input type="submit" value=<%=down %>>
    </form>
    </div>
  </body>
</html>
