<%@ page language="java" import="java.util.*,com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%  
    
     String totalPrice = (String) request.getAttribute("totalPrice");
     if(totalPrice == null){
        totalPrice = "0";
     }
     List<ShopCartDetail> shopCartDetailList = (List<ShopCartDetail>)request.getAttribute("shopCartDetailList");
     String delRes = (String) request.getAttribute("delRes");
     if(delRes == null){
        delRes = "";
     }
     
   %>
   <style type="text/css">
      td{
         width: 100px;
      }
      th{
         width: 100px;
      }
   
   </style>
  </head>
  
  <body>
     <div style="background: skyblue; height: 40px;line-height: 40px;">
        <a href="AaShoppingHomePageServlet">返回首页</a>
    </div>
  
  
 	 <div style="position: absolute; left: 300px; top: 200px;">
 	    <b style="position: absolute; left: 300px; top: -20px;">购物车</b>
 	    <label style="position: absolute; color: red; top: -20px;"><%=delRes %></label>
	    <table style="text-align: center;" border="2" cellspacing="2">
	       <tr>
	          <th>商品ID</th>
	          <th>商品名</th>
	          <th>商品类型</th>
	          <th>商品单价</th>
	          <th>商品数量</th>
	          <th>商品总价</th>
	          <th>编辑操作</th>
	       </tr>
	       <%for(int i = 0; i < shopCartDetailList.size(); i ++){ %>
	       <tr>
	          <td><%=shopCartDetailList.get(i).getSid() %></td>
	          <td><%=shopCartDetailList.get(i).getSname() %></td>
	          <td><%=shopCartDetailList.get(i).getStype() %></td>
	          <td><%=shopCartDetailList.get(i).getSprice() %>.00￥</td>
	          <td><%=shopCartDetailList.get(i).getShopQuantity() %>.0</td>
	          <td><%=shopCartDetailList.get(i).getShopPrice() %>.00￥</td>
	          <td>
	             <form action="DeleteShopInCartServlet" method="post">
	                <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopCartDetailList.get(i).getShopQuantity() %> name="quantity">
	                <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopCartDetailList.get(i).getSid() %> name="sid">
	                <input type="submit" value="删除">
	             </form>
	          </td>
	       </tr>
	       <%} %>
	    </table>
	    <label style="position: absolute; left: 600px;">总价为: <%=totalPrice %>.00￥</label><br>
	    <form action="ShopCartPayServlet" method="post">
	       <input style="position: absolute; left: 650px;" type="submit" value="点击前往付款">
	    </form>
	       
	    
	    
	    
	    
	</div>
  </body>
</html>
