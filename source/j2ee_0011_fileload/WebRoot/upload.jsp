<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>File upload test</title>
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
    <h1>File upload test</h1><hr>
    <form name="form1" action="UpLoadAction" method="post" enctype="multipart/form-data">
    <table>
      <tr>
        <td>上传人:</td>
        <td><input type="text" name="username"/></td> 
      </tr>
      <tr>
        <td>上传文件：</td>
        <td><input type="file" name="file"/></td> 
      </tr>
        <tr>
        <td><input type="reset" value="重置"/></td>
        <td><input type="submit" value="提交"/></td> 
      </tr>
        <tr>
        <td></td>
        <td> </td> 
      </tr>
    </table>
    </form>
  </body>
</html>
