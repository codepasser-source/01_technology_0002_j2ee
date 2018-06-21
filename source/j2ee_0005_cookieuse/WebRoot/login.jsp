<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>cookie 用途</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <h1 ailgn="center">cookie 用途 </h1><br>
   <form action="Login" method="post">
           用户名：<input type="text" name = "username" value="">   <br>
           密码    : <input type="password" name = "password"  value=""><br>
      
      <input type="checkbox" name="remember" id="remenber"> 记住密码   
      
       <input type="submit" value="登录">  
    
   </form> 
  </body>
</html>
