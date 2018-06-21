<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
<script type="text/javascript" src="<%=basePath%>jslib/msgbox.js"></script>  
  <body onload="start();">
    <h1>js ajax 实现消息及时更新demo</h1> 
    <h3>js 设置间隔时间执行访问 ajaxserver</h3>
    <hr> 
    用户登录时保存ID:<input type="text" value="1" id="user_id">
    <br>
    <input onclick="reSetPopTop()" type="button" value="显示消息"/>
    <input onclick="hiben()" type="button" value="隐藏消息"/>
  </body>
</html>
