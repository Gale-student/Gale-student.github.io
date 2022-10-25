<%@ page language="java" import="java.util.*,com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OrdersPaidQueryOfUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
      List<OrdersDetail> ordersDetailList = (List<OrdersDetail>)request.getAttribute("ordersDetailList");
     
      int currentPage = (Integer) session.getAttribute("currentPage");
      int allPage = (Integer) session.getAttribute("allPage");
      
      String upPage = "上一页";
      String downPage = "下一页";
      if(currentPage == 1){
         upPage = "首页";
      }
      if(currentPage == allPage){
         downPage = "尾页";
      }
   %>
    <style type="text/css">
     th{
        width: 100px;
     }
     td{
        width: 100px;
     }
   </style>
  </head>
  
  <body>
    <div style="background: skyblue; height: 40px;line-height: 40px;">
        <a href="AaShoppingHomePageServlet">返回首页</a>
    </div>
    
    <table style="position: absolute; left: 400px; top: 200px; text-align: center;" border="2" cellspacing="2">
       <tr>
          <th>订单编号</th>
          <th>商品名</th>
          <th>商品价格</th>
          <th>购买数量</th>
          <th>单个商品总价</th>
          <th>下单时间</th>
          <th>订单状态</th>
       </tr>
       <%for(int i = 0; i < ordersDetailList.size(); i ++){ %>
       <tr>
          <td><%=ordersDetailList.get(i).getOid() %></td>
          <td><%=ordersDetailList.get(i).getSname() %></td>
          <td><%=ordersDetailList.get(i).getSprice() %>.00￥</td>
          <td><%=ordersDetailList.get(i).getQuantity() %>.0</td>
          <td><%=ordersDetailList.get(i).getShopPrice() %>.00￥</td>
          <td><%=ordersDetailList.get(i).getDate() %></td>
          <td><%=ordersDetailList.get(i).getStatus() %></td>
       </tr>
       <%} %>
    </table>
    <div style="position: absolute; left: 700px; top: 400px;">
    <form action="OrdersDetailPaidUpPageServlet" method="post">
       <input type="submit" value=<%=upPage %>>
    </form>
    <label style="position: absolute; top: 0px; left: 65px;"><%=currentPage + "/" + allPage %></label>
    <form style="position: absolute; top: 0px; left: 100px;" action="OrdersDetailPaidDownPageServlet" method="post">
       <input type="submit" value=<%=downPage %>>
    </form>
    </div>
    
  </body>
</html>