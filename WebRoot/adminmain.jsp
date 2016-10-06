<%@page import="com.chinasoft.bean.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理页面</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="js/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="js/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->
<script type="text/javascript" src="js/jquery.datePicker.js"></script>
<script type="text/javascript" src="js/jquery.date.js"></script>
</head>
<%
	Object obj=session.getAttribute("admin");
	Admin admin=new Admin();
	if(obj!=null){
		admin=(Admin)obj;
	}else{
		out.print("登录过期，重新登录");
	}
	if(admin.getAdminNumber()==null){
		response.sendRedirect("prompt.jsp");
	}
 %>
 
<body>
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">途乐行</a></h1>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> <h5>您好, <%=admin.getAdminNumber() %></h5>
   	  </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="Exit" class="nav-top-item no-submenu">退出登录 </a> </li>
        <li> <a href="GetLine" class="nav-top-item no-submenu" >线路管理</a></li>
        <li> <a href="GetOrders" class="nav-top-item no-submenu" >订单管理</a> </li>
        <li> <a href="GetUsers" class="nav-top-item no-submenu"> 会员管理 </a>  </li>
        <li> <a href="#" class="nav-top-item"> 酒店管理 </a> </li>
        <li> <a href="#" class="nav-top-item"> 待定 </a>  </li>
      </ul>
      <!-- End #main-nav -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content">
    <!-- Main Content Section with everything -->
    <noscript>
    <!-- Show a notification if the user has disabled javascript -->
    </noscript>
    <!-- Page Head -->
    <h2>途乐行后台管理系统</h2>
  	<div><img alt="" src="img/universe1.jpg"/></div>
    <div id="footer"> <small>
      <!-- Remove this notice or replace it with whatever you want -->
      &#169; Copyright 2010 Your Company | Powered by <a href="#">admin templates</a> | <a href="#">Top</a> </small> </div>
    <!-- End #footer -->
  </div>
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
