<%@ page language="java" import="java.util.*,com.company.service.*,com.company.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="CSS/ShoppingHomePage.css">
  </head>
  <%
     
     String uid = (String) session.getAttribute("uid");
     
     UserService userService = new UserServiceImpl();
     List<User> userList = userService.queryUserInfo(uid);
     
     int shopCartAllRows = userService.shopCartAllRows(uid);
	 
     String uname = "";
     String uaddress = "";
     String ugender = "";
     String uage = "";
     String utel = "";
     if(uid != null){
        uname = userList.get(0).getUname();
	    uaddress = userList.get(0).getUaddress();
	    ugender = userList.get(0).getUgender();
	    uage = userList.get(0).getUage();
	    utel = userList.get(0).getUtel();
     }
     
     String uimage = userService.userImageDisplay(uid);
     //String uimage = (String) session.getAttribute("uimage");
     String disUimage = "/himage/" + uimage;
     String unameDis = "欢迎" + uname ;
     String login = "";
     String register = "";
     String logout = "退出登录";
     String shopCart = "购物车" + "(" + shopCartAllRows + ")";
     String selectOrders = "查看订单";
     if(uid == null){
        uid = "";
        unameDis = "";
        login = "登录";
        register = "注册";
        logout = "";
        shopCart = "购物车(0)";
        selectOrders = "";
     }
     
     String upwdModifyRes = (String)request.getAttribute("upwdModifyRes");
     System.out.println(upwdModifyRes);
     if(upwdModifyRes == null){
        upwdModifyRes = "";
     }
     
     String editRes = (String) request.getAttribute("editRes");
     if(editRes == null){
        editRes = "";
     }
     
     List<Shop> shopList = (List<Shop>)request.getAttribute("shopList");
     int currentPage = (Integer) session.getAttribute("currentPage");
     int allPage = (Integer) session.getAttribute("allPage");
     String downPage = "下一页";
     String upPage = "上一页";
     if(currentPage == 1){
        upPage = "首页";
     }
     if(currentPage == allPage){
        downPage = "尾页";
     }
     
     String queryRes = (String) request.getAttribute("queryRes");
     if(queryRes == null){
        queryRes = "";
     }
   %>
  
   <script type="text/javascript">
   
      window.onload = function(){
         var uid = "<%=uid %>";
         var oImg = document.getElementById("disUimage");
         var oMenu = document.getElementById("menu");
         var modifyUpwdBtn = document.getElementById("modifyUpwd");
         var modifyUpwdForm = document.getElementById("modifyUpwdForm");
         
         var personInfo = document.getElementById("personInfo");
         var disInfo = document.getElementById("disInfo");
         var editBtn = document.getElementById("editBtn");
         
         var change = document.getElementById("change");
         
         var oOrders = document.getElementById("orders");
         var oList = document.getElementById("list");
         oOrders.onclick = function(){
            if(oList.style.visibility == "hidden"){
               oList.style.visibility = "visible";
            }else{
               oList.style.visibility = "hidden";
            }
         }
         
         if(uid == ""){
            oImg.style.visibility = "hidden";
            oMenu.style.visibility = "hidden";
         }
         
         modifyUpwdBtn.onclick = function(){
            if(modifyUpwdForm.style.visibility == "hidden"){
               modifyUpwdForm.style.visibility = "visible";
            }else{
               modifyUpwdForm.style.visibility = "hidden";
            }
         }
         personInfo.onclick = function(){
            if(disInfo.style.visibility == "hidden"){
               disInfo.style.visibility = "visible";
               
            }else{
               disInfo.style.visibility = "hidden";
               change.style.visibility = "hidden";
            }
         }
         editBtn.onclick = function(){
            if(change.style.visibility = "hidden"){
               change.style.visibility = "visible";
            }else{
               change.style.visibility = "hidden";
            }
            
         }
         
         addCart.onclick = function(){
            alert(addCart);
            var cartNum = document.getElementById("cartNum");
            alert(cartNum);
         }
      }
   </script>
  <body>
    
    <!-- 顶部栏 -->
    <div class="topBar">
        <div class="container">
            <div class="topBar_list">
               <a id="orders" style="cursor:pointer;" ><%=selectOrders %></a>
               <div id="list" style="position: absolute; left: 140px; top: 40px; background: skyblue; visibility: hidden;border-radius: 5%;">
                  <label><a href="OrdersDetailQueryAllServlet?url=WEB-INF/jsp/OrdersQueryOfUser.jsp">查看所有订单</a></label><br/>
                  <label><a href="OrdersDetailUnpaidQueryServlet">查看未支付订单</a></label><br/>
                  <label><a href="OrdersDetailPaidQueryServlet">查看已支付订单</a></label><br/>
               </div>
            
            </div>
            <div class="shop">
                <a href="ShopCartViewServlet?url=WEB-INF/jsp/ShopCart.jsp"><%=shopCart %></a>
                <a href="LogoutServlet" style="position: absolute;"><%=logout %></a>
            </div>
            <div class="login">
                <b style="position: absolute; left: 1090px; top: 15px;"><%=unameDis %></b>
                <a href="UserLogin.jsp" ><%=login %></a>
                <!-- <span style="position: absolute; left: 1200px;">|</span> -->
                <img id="disUimage" style=" position: absolute; width: 40px; height: 40px; border-radius: 50%;" src=<%=disUimage %>>
                <a href="UserRegister.jsp"><%=register%></a>
                <span>|</span>
            </div>
        </div>
    </div>
    <!-- 导航栏 -->
    <div class="header">
        <div class="container">
           <div class="site_logo">
               <a href="#">
                   <img src="/limage/site_logo1.png">
               </a>
           </div>
        </div>
    </div>
     <div>
         <img style="position: absolute;width: 160px; height: 150px; top: 70px; left: 800px;" src="/bimage/gx.jpg">
     </div>
    <div class="site_search" style="position: absolute; left: 145px; top: 180px;">
        <form action="QueryShopBySnameServlet" method="post">
            <input type="text" placeholder="请输入你需要的商品名" name="sname">
            <input type="submit" value="搜索"> 
        </form>
        <form style="position: absolute;left: 300px; top: 0px;" action="AaShoppingHomePageServlet" method="post">
            <input type="submit" value="查询所有商品">
        </form>
        <label style="color: red;"><%=queryRes %></label>
    </div>
    <!-- 主页内容start -->
    <div class="container" style="margin-top: 90px;">
        <% for(int i = 0; i < shopList.size(); i ++){ %>
        <div style="border: 2px solid skyblue;width: 1000px;">
            <img style="width: 100px; height: 110px;" src=<%= "/simage/" + shopList.get(i).getSimage() %>>
            <label style="position: absolute; left: 270px;"><%=shopList.get(i).getSname() %></label>
            <label style="position: absolute; margin-left: 150px;"><%=shopList.get(i).getSprice() %>.00￥</label>
            <label style="position: absolute; margin-left: 100px; margin-top: 50px;">库存：<%=shopList.get(i).getScount() %>.00</label>
            <form style="position: absolute; left: 500px; margin-top: -50px;" action="ShopBuyServlet" method="post">
                <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopList.get(i).getSid() %> name="sid">
                <input style="width: 50px;" type="number" value="1" min="1" max=<%=shopList.get(i).getScount() %> name="quantity">
                <input type="submit" value="立即购买">
            </form>
            <form style="position: absolute; left: 700px; margin-top: -50px;" action="AddCartServlet" method="post">
                <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopList.get(i).getSid() %> name="sid">
                <input style="width: 50px;" type="number" value="1" min="1" max=<%=shopList.get(i).getScount() %> name="shopQuantity">
                <input type="submit" value="加入购物车">
            </form>
        </div>
        <label>-----------------------------------------------------------------------------------------------------</label>
        <% } %>
        <form style="position: absolute; top: 650px; left: 400px;" action="ShoppingHomePageUpPageServlet" method="post">
            <input type="submit" value=<%=upPage %>>
        </form>
        <label style="position: absolute; top: 650px; left: 500px;"><%=currentPage + "/" + allPage %></label>
        <form style="position: absolute; top: 650px; left: 600px;" action="ShoppingHomePageDownPageServlet" method="post">
            <input type="submit" value=<%=downPage %>>
        </form>
    </div>
    <!-- 主页内容end -->
    <div id="menu" style="position: absolute; width: 200px; height: 500px; left: 1200px; top: 100px; background: skyblue;">
       <input id="modifyUpwd" type="button" value="点击修改密码"><label style="color: red;"><%=upwdModifyRes %></label>
       <form id="modifyUpwdForm" style="visibility: hidden" action="UserModifyUpwdServlet" method="post">
	       <label>旧密码：</label><input type="password" name="oldUpwd"><br>
	       <label>新密码：</label><input type="password" name="newUpwd">
	       <input type="submit" value="提交">
       </form>
       <input id="personInfo" type="button" value="查看并修改个人信息"><br><label style="color: red;" ><%=editRes %></label>
       <div id="disInfo" style="visibility: hidden">
          <form action="UserEditInfoServlet" method="post">
	          <label>账号：</label><input type="text" value=<%=uid %> readonly="readonly" name="uid">*<br>
	          <label>姓名：</label><input type="text" value=<%=uname %> name="uname"><br>
	          <label>地址：</label><input type="text" value=<%=uaddress %> name="uaddress" ><br>
	          <label>性别：</label><input type="text" value=<%=ugender %> name="ugender"><br>
	          <label>年龄：</label><input type="text" value=<%=uage %> name="uage" ><br>
	          <label>电话：</label><input type="text" value=<%=utel %> name="utel" ><br>
	          <input id="editBtn" type="button" value="编辑信息">
	          <input id="change" style="visibility: hidden;" type="submit" value="确认提交" >
          </form>
       </div>
       
    </div>
    
  </body>
</html>