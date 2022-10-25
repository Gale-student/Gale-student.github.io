<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
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
         background: url("image/reg_bg.jpg");
      }
      #box{
         background: white;
         position: absolute;
         left:600px;
         top:200px;
         height:403px;
         width: 450px;
         border:2px solid white;
         text-align: center;
         line-height: 50px;
         //border-radius:5%;
         opacity: 0.85;
      }
      input{
         padding : 10px;
         margin: 10px;
      }
      #l1{
         position:absolute;
         font-size: 30px;
         width: 450px;
         background: skyblue;
      }
      #d1{
         position: absolute;
         left:93px;
      }
      #l2{
         color:red;
         position: absolute;
         top: 73px;
         left: 147px;
      }
      #btninput{
         width: 265px;
      }
      #lb1{
         color: red;
         position: absolute;
      }
      #lb2{
         color: red;
         position: absolute;
      }
      #lb3{
         color: red;
         position: absolute;
      }
      
   </style>
   <script type="text/javascript">
      window.onload = function(){
         var uidIn = document.getElementById("uidinput");
         var upwdIn = document.getElementById("upwdinput");
         var upwd2In = document.getElementById("upwd2input");
         var oLb1 = document.getElementById("lb1");
         var oLb2 = document.getElementById("lb2");
         var oLb3 = document.getElementById("lb3");
         var oLb4 = document.getElementById("lb4");
         var btnIn = document.getElementById("btninput");
         var MyCode = document.getElementById("MyCode");
         uidIn.onblur = function(){
            var uid = uidIn.value;
            var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
            xhr.open("post", "UidCheckServlet?uid="+uid, true);
            xhr.onreadystatechange = function(){
               if(xhr.readyState == 4){
                   if(xhr.status == 200){
                       var result = xhr.responseText;//只能返回文本型
                       if(result == "success"){
                          oLb1.innerHTML = "√";
                       }else if(result == "exist"){
                          oLb1.innerHTML = "账号已存在!";
                       }else{
                          oLb1.innerHTML = "×"
                       }
                   }
                }
            }
            xhr.send();
         }
         upwdIn.onblur = function(){
            var upwd = upwdIn.value;
            var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
            xhr.open("post", "UpwdCheckServlet?upwd="+upwd, true);
            xhr.onreadystatechange = function(){
               if(xhr.readyState == 4){
                   if(xhr.status == 200){
                       var result = xhr.responseText;//只能返回文本型
                       if(result == "success"){
                          oLb2.innerHTML = "√";
                       }else{
                          oLb2.innerHTML = "×";
                       }
                   }
                }
            }
            xhr.send();
         }
         upwd2In.onblur = function(){
            var upwd = upwdIn.value;
            var upwd2 = upwd2In.value; 
            var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
            xhr.open("post", "Upwd2CheckServlet?upwd="+upwd+"&upwd2="+upwd2, true);
            xhr.onreadystatechange = function(){
               if(xhr.readyState == 4){
                   if(xhr.status == 200){
                       var result = xhr.responseText;//只能返回文本型
                       if(result == "success"){
                          oLb3.innerHTML = "√";
                       }else{
                          oLb3.innerHTML = "×";
                       }
                   }
                }
            }
            xhr.send();
         }
         //发送验证码
         
                  
        var InterValObj; //timer变量，控制时间
		var count = 60; //间隔函数，1秒执行
		var curCount;//当前剩余秒数
        var SendIn = document.getElementById("sendinput");
        SendIn.onclick = function(){
            curCount = count;
	        SendIn.setAttribute("disabled",true);
	        SendIn.value=curCount + "秒后重获";
	        var uid = uidIn.value;
	        InterValObj = window.setInterval(SetRemainTime, 1000); 
	            var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
	            xhr.open("post", "SendCodeServlet?uid="+uid, true);
	            xhr.onreadystatechange = function(){
	                if(xhr.readyState == 4){
	                    if(xhr.status == 200){
	                      
	                    }
	                }
	            }
	            xhr.send();
	         }
         function SetRemainTime() {
		     if (curCount == 0) {//超时重新获取验证码                
			     window.clearInterval(InterValObj);// 停止计时器
				     SendIn.removeAttribute("disabled");//移除禁用状态改为可用
					 SendIn.value="重获验证码";
				 }else {
					 curCount--;
					 SendIn.value=curCount + "秒后重获";
				 }
			 }
         //验证码校验

        MyCode.onblur = function(){
            var mycode = MyCode.value;
            var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
	        xhr.open("post", "MyCodeCheckServlet?mycode="+mycode, true);
            xhr.onreadystatechange = function(){
	            if(xhr.readyState == 4){
	                if(xhr.status == 200){
	                    var result = xhr.responseText;
	                        if(result == "success"){
	                            oLb4.innerHTML = "√";
	                        }else{
	                            oLb4.innerHTML = "×";
	                        }
	                    }
	                }
	            }
	            xhr.send();
           }
      
          btnIn.onclick = function(){
            var uid = uidIn.value;
            var upwd = upwdIn.value;
            var uidres = oLb1.innerHTML;
            var upwdres = oLb2.innerHTML;
            var upwd2res = oLb3.innerHTML;
            var mycodeRes = oLb4.innerHTML;
            if(uidres == "√" && upwdres == "√" && upwd2res == "√" && mycodeRes == "√"){
               var xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
               xhr.open("post", "UserRegisterServlet?uid="+uid+"&upwd="+upwd, true);
               xhr.onreadystatechange = function(){
               if(xhr.readyState == 4){
                   if(xhr.status == 200){
                       var result = xhr.responseText;
                       if(result == "error"){
                          oLb1.innerHTML = "账号已存在!";
                       }
                       window.open("UserLogin.jsp", '_blank');
                   }
                }
            }
            xhr.send();
            }else{
               alert("注册失败, 请检查账号、密码和验证码是否已填写完整并且格式正确");
            }
         }
         
      
         
      }
   
   </script>
  </head>
  <body>
  <div id = "box">
       <div id="l1">欢迎注册</div><br>
       <div id="d1">已有账号，<a href="UserLogin.jsp">点击前往登录页面</a></div><br>
       <label>手机号：</label><input id="uidinput" type="text" placeholder="请输入账号/手机号" ><label id="lb1"></label><br>
       <label>密 &nbsp;&nbsp;码：</label><input id="upwdinput" type="password" placeholder="请输入密码,6位数仅包含数字"><label id="lb2"></label><br>
       <label>确认密码:</label><input id="upwd2input" type="password" placeholder="请确认密码,密码需一致"><label id="lb3"></label><br>
       <label>验证码：</label><input style="width: 70px;" type="text" placeholder="请输入收到的验证码" id="MyCode" >
       <input id="sendinput" type="button" value="发送验证码"><label style="position: absolute; color: red;" id="lb4"></label><br>
       <input id="btninput" type="button" value="注册" >
    </div>
  </body>
</html>
