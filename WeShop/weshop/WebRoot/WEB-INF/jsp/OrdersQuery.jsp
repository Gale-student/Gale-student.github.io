<%@ page language="java" import="java.util.*,com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OrdersQuery.jsp' starting page</title>
    
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
     String mname = (String)session.getAttribute("mname");
     String ordersDelRes = (String)request.getAttribute("ordersDelRes");
     if(ordersDelRes == null){
        ordersDelRes = "";
     }
     List<Orders> ordersList = (List<Orders>)request.getAttribute("ordersList");
     String msg = "";
     if(ordersList.size() == 0){
         msg = "没有找到订单信息";
         request.setAttribute("msg", msg);
     }
     String unpaidOrders = (String) request.getAttribute("unpaidOrders");
     if(unpaidOrders == null){
        unpaidOrders = "";
     }
     int ordersCurrentPage = (Integer) session.getAttribute("ordersCurrentPage");
      String up = "上一页";
      if(ordersCurrentPage == 1){
         up = "首页";
      }
      request.setAttribute("up", up);
      int ordersAllPage = (Integer) session.getAttribute("ordersAllPage");
      String down = "下一页";
      if(ordersCurrentPage == ordersAllPage){
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
          top: 160px;
       }
       #down{
          position: absolute;
          left:610px;
          top: 160px;
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
    
    <label style="position: absolute;color: red; left: 400px; top: 230px;"><%=msg %></label>
    <form id="search" action="OrdersQueryByOidServlet" method="post">
	    <input type="text" placeholder="请输入订单编号" name="oid">
	    <input type="submit" value="搜索">
    </form>
    
    <form style="position: absolute; left: 630px; top: 50px;" action="CancelOrdersServlet" method="post">
	    <input type="text" placeholder="请输入订单编号" name="oid">
	    <input type="submit" value="删除订单">
	    <label style="color: red;"><%=ordersDelRes %></label>
    </form>
    
    <form style="position: absolute; left: 630px; top: 100px;" action="OrdersQueryUnpaidServlet" method="post">
	    <input type="submit" value="查询未支付订单">
	    <label style="color: red;"><%=unpaidOrders %></label>
    </form>
    <table border="2" cellspacing="2" >
       <tr id="tablehead">
          <th>订单编号</th>
          <th>用户ID</th>
          <th>商品ID</th>
          <th>购买数量</th>
          <th>下单时间</th>
          <th>付款状态</th>
       </tr>
       <% for( int i = 0; i < ordersList.size(); i ++){ %>
          <tr>
             <td><%=ordersList.get(i).getOid()%></td>
             <td><%=ordersList.get(i).getUid()%></td>
             <td><%=ordersList.get(i).getSid()%></td>
             <td><%=ordersList.get(i).getQuantity()%></td>
             <td><%=ordersList.get(i).getDate()%></td>
             <td><%=ordersList.get(i).getStatus()%></td>
          </tr>
       <% } %>
    </table>
    
     <form id="up" action="OrdersUpPageServlet" method="post">
       <input type="submit" value=<%=up %>>
       <label><%=ordersCurrentPage + "/" + ordersAllPage %></label>
    </form>
    <form id="down" action="OrdersDownPageServlet" method="post">
       <input type="submit" value=<%=down %>>
    </form>
    </div>
  </body>
</html>
