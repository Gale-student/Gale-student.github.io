<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品页面</title>
    
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
	   String mname = (String)session.getAttribute("mname");
	 %>
	<link rel="stylesheet" type="text/css" href="CSS/ManagerHomePage.css">
  <style type="text/css">
      #box{
          position: absolute;
          left: 650px;
          top: 200px;
          line-height: 20px ;
      }
      input{
          padding: 10px;
          margin: 6px;
          height: 35px;
      }
      label{
          position: absolute;
          left: -110px;
          padding: 9px;
          /*font-size: 20px;*/
      }
      #submit{
         position: absolute;
         left: -105px;
         width: 288px;
      }
      #msg{
         color: red;
      }
  
  </style>
  </head>
  
  <body>
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
            <li class="main_nav"><a href="ShopPagingQueryServlet?url=WEB-INF/jsp/ShopQuery.jsp">商品管理</a></li>
		    <li class="main_nav"><a href="OrdersPagingQueryServlet?url=WEB-INF/jsp/OrdersQuery.jsp">订单管理</a></li>
		    <li class="main_nav"><a href="PagingQueryServlet?url=WEB-INF/jsp/PagingQuery.jsp">用户管理</a></li>
			<li class="main_nav">
			    <a href="ManagerLogin.jsp"  target="_parent">退出</a>
			</li>
	    </ul>
    </div>
  <div id="box">
    <form action="ShopAddServlet" method="post" enctype="multipart/form-data">
        <label id="msg" style="position: abslute; top: -20px; left: 0px;"><%=msg %></label>
	    <label>商 品 ID: </label><input type="text" placeholder="请输入商品id" name="sid"/><br>
	    <label>商 品 名: </label><input type="text" placeholder="请输入商品名" name="sname"/><br>
	    <label>商品类型: </label><input type="text" placeholder="请输入商品类型" name="stype"/><br>
	    <label>商品库存: </label><input type="text" placeholder="请输入商品库存" name="scount"/><br>
	    <label>商品价格: </label><input type="text" placeholder="请输入商品价格" name="sprice"/><br>
	    <label>商品图片: </label><input type="file" value="请输入商品id" name="simage"/><br>
	    <input id="submit" type="submit" value="提交">
    </form>
    </div>
  </body>
</html>
