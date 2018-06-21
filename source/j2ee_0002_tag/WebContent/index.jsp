<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.baishui_c.org/taglib1" prefix="mytag1" %>
<%@taglib uri="http://www.baishui_c.org/taglib2" prefix="mytag2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<mytag1:say/>
<br>
<mytag2:say url="http://localhost"/>
<br>
<mytag2:dyna 书名="轻量级J2EE企业应用实战" 价格="88.8" sldfj="asdfasdf"/>
</body>
</html>