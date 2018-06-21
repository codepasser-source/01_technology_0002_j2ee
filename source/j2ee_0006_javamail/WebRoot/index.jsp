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
  
  <body>
   <h1 align="center"> java email demo</h1>
   <hr> 
   <form action="SendMail" method="post">
   <table align="center" bgcolor="#5a5a5a" border="0" cellpadding="0" cellspacing="2">
    <tr height="30" bgcolor="#ffffff">
     <td width="80" align="right">收件人：</td>
     <td width="400"><input type="text" name="sendTo" value="239081196@qq.com"></td>
    </tr>
     <tr height="30" bgcolor="#ffffff">
     <td width="80" align="right">发件人：</td>
     <td width="400"><input type="text" name="from" value="baishui_c@sina.com"></td>
    </tr>
     <tr height="30" bgcolor="#ffffff">
     <td width="80" align="right">主题：</td>
     <td width="400"><input type="text" name="theme" value="测试"></td>
    </tr>
     <tr height="30" bgcolor="#ffffff">
     <td width="80" align="right" valign="top">内容：</td>
     <td width="400">
     <textarea name="content" rows="5" cols="50">测试内容</textarea>
     </td>
    </tr>
     <tr height="30" bgcolor="#ffffff">
     <td width="480" colspan="2" align="right">
      <input type="submit" value="发送">&nbsp;
     </td> 
    </tr>
   </table>
   </form>
  </body>
</html>
