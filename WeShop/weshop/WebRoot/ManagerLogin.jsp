<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <%

	   Cookie[] carr = (Cookie[]) request.getCookies();
       String mid = "";
       if(carr != null){//直接判断数组是否为空
         for(Cookie c : carr){
           if(c.getName().equals("mid")){
            mid = c.getValue();
           }
         }
       }
	   String res = (String)request.getAttribute("res");
	   if(res == null){
	      res = "";
	   }

	 %>
   <style type="text/css">
      body{
         background: url("/bimage/ManagerBg.jpg");
         background-size: cover; 
      }
      #d2{
         font-size: larger;
         width: 320px;
         background: skyblue;
      }
      #l1{
         color: red;
         position: absolute;
         left: 30px;
      }
      #box{
         width: 320px;
         height: 400px;
         position: absolute;
         left: 900px;
         top: 135px;
         border: 1px solid skyblue;
         border-radius: 2%;
         text-align: center;
         line-height: 50px;
         background: white;
         opacity: 0.9;
      }
      input{
         padding: 10px;
         margin: 10px;
         width: 260px;
      }
   </style>
   <script type="text/javascript">
 
      function testfun(){
         var mid = document.forms["fm"]["mid"].value;
         var mpwd = document.forms["fm"]["mpwd"].value;
         if(mid == null || mid == ""){
            alert("请输入账号");
            return false;
         }else if(mpwd == null || mpwd == ""){
            alert("请输入密码");
            return false;
         }
         return true;
      }
 
   </script>
  </head>
  
  <body>
    <div id="d1"></div>
    <div id="box">
       <form id="fm" action="ManagerLoginServlet" method="post" onsubmit="return testfun()">
          <div id="d2">欢迎管理者</div>
          <label id="l1"><%=res%></label><br>
          <input type="text" placeholder="请输入账号" name="mid" value=<%=mid %>><br>
          <input type="password" placeholder="请输入密码" name="mpwd"><br>
          <input type="submit" value="登录">
       </form>
          <div>
             <a href="#" >找回密码waiting</a>
          </div>
    </div>
  </body>
</html>
