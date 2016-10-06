<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head></head>
<body>
<%
	out.print("登陆过期，重新登录");
	response.setHeader("Refresh", "1,URL=adminlogin.jsp");
 %>
</body>
</html>