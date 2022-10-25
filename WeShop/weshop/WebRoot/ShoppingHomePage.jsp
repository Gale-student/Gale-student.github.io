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
     ManagerService managerService = new ManagerServiceImpl();
     List<Shop> shopList = managerService.PagingQuery(0);
     request.setAttribute("shopList", shopList);
     int disRows = 0;
     int allRows = managerService.AllRows();
     if(allRows / 3 == 0){
        disRows =  allRows / 3;
     }else{
        disRows = allRows / 3 + 1;
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
           <div class="site_search">
               <form action="">
                   <input type="text" name="shop">
                   <input type="submit"> 
                   <div class="search_word">
                       <a href="#">红富士苹果</a>
                        <a href="#">红心猕猴桃</a>
                   </div>
               </form>
           </div>
        </div>
    </div>
    <!-- 主页内容start -->
    <div class="container">
    <%for( int j = 0; j < disRows - 1; j ++){ %>
       <% shopList = managerService.PagingQuery(j); %>
       <% for(int i = 0; i < 3; i ++){ %>
        <div style="position: absolute; top: <%=200 + 300*j %>px; left: <%=200 + 300*i %>px">
           <form action="ShopBuyServlet" method="post">
              <input style="position: absolute;  visibility: hidden;" type="text" value=<%=shopList.get(i).getSid() %> name="sid"> 
	          <img style="width: 200px; height: 220px;" src=<%="/simage/" + shopList.get(i).getSimage()%>><br>
	          <label><%=shopList.get(i).getSname() %></label><br>
	          <label><%=shopList.get(i).getSprice() + ".0￥" %></label>
	          <input style="width: 50px;" type="number" placeholder="数量" value="1" name="quantity" min="1">
	          <input type="submit" value="立即购买"><br>
           </form>
           <div style="position: absolute; top:270px;">
	           <form action="AddCartServlet" method="post">
	              <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopList.get(i).getSid() %> name="sid">
	              <input style=" width: 50px;" type="number" placeholder="数量" value="1" name="shopQuantity" min="1">
	              <input class="addCart" type="submit" value="加入购物车">
	           </form>
           </div>
        </div>
       <% } %>
    <% } %>
     <% shopList = managerService.PagingQuery(disRows - 1); %>
    <%for(int k = 0; k < allRows % 3; k ++){ %>
       <div style="position: absolute; top: <%=200 + 300*(disRows-1) %>px; left: <%= 200 + 300*k %>px;">
           <form action="ShopBuyServlet" method="post">
           <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopList.get(k).getSid() %> name="sid">
           <img style="width: 200px; height: 220px;" src=<%="/simage/" + shopList.get(k).getSimage()%>><br>
           <label><%=shopList.get(k).getSname()%></label><br>
           <label><%=shopList.get(k).getSprice() + ".0￥" %></label>
           <input style="width: 50px;" type="number" placeholder="数量" value="1" name="quantity" min="1">
           <input type="submit" value="购买"><br>
           </form>
           <div style="position: absolute; top:270px;">
           <form action="AddCartServlet" method="post">
              <input style="position: absolute; visibility: hidden;" type="text" value=<%=shopList.get(k).getSid() %> name="sid">
              <input style="width: 50px;" type="number" placeholder="数量" value="1" name="shopQuantity" min="1">
              <input class="addCart" type="submit" value="加入购物车">
           </form>
           </div>
       </div>
    <% } %>
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
