<%@page import="com.chinasoft.bean.Orders"%>
<%@page import="com.chinasoft.dao.OrdersDAO"%>
<%@page import="com.chinasoft.dao.LinesDAO"%>
<%@page import="com.chinasoft.bean.Lines"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.chinasoft.bean.Admin"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
  	String orderid= request.getParameter("orderid");
  	OrdersDAO od=new OrdersDAO();
  	Orders orders=new Orders();
  	if(orderid!=null){
	  	orders=od.getOrderById(Integer.parseInt(orderid));	
  	}else{
  		Object obj=request.getAttribute("orderid");
  		if(obj!=null){
  			orderid=obj.toString();
  			orders=od.getOrderById(Integer.parseInt(orderid));
  		}else{
  		}
  	}

	Object obj=session.getAttribute("admin");
	Admin admin=new Admin();
	if(obj!=null){
		admin=(Admin)obj;
	}else{
		out.print("登录过期，重新登录");
		response.setHeader("Refresh", "1,URL=adminlogin.jsp");
	}
	if(admin.getAdminNumber()==null){
		out.print("登录过期，重新登录");
		response.setHeader("Refresh", "1,URL=adminlogin.jsp");
	}
 %>
 
<body>
<div id="sidebar">
    <div id="sidebar-wrapper">
     	 <!-- Sidebar with logo and menu -->
    	<h1 id="sidebar-title"><a href="#">途乐行</a></h1>
     	 <!-- Sidebar Profile links -->
    <div id="profile-links"> <h5>您好, <%=admin.getAdminNumber() %></h5>
    </div>
    <ul id="main-nav">
        <!-- Accordion Menu -->
        <li> <a href="Exit" class="nav-top-item no-submenu">
          <!-- Add the class "no-submenu" to menu items with no sub menu -->
        	  退出登录 </a> </li>
        <li> <a href="GetLine" class="nav-top-item ">
          <!-- Add the class "current" to current menu item -->
          	线路管理</a>
        <ul>
            <li><a href="GetLine" class="current">查看线路</a></li>
            <li><a href="#" class="current">待定功能</a></li>
        </ul>
        </li>
        <li> <a href="GetOrders" class="nav-top-item current"> 订单管理 </a>
          <ul>
            <li><a href="GetOrders" class="current">订单查询</a></li>
            <li><a href="#" class="current">待定功能</a></li>
          </ul>
        </li>
        <li> <a href="GetUsers" class="nav-top-item"> 会员管理 </a>
          <ul>
            <li><a href="GetUsers" class="current">所有会员</a></li>
            <li><a href="#" class="current">待定功能</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 酒店管理 </a>
          <ul>
            <li><a href="#" class="current">酒店查询</a></li>
            <li><a href="#" class="current">待定功能</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 待定 </a>
          <ul>
            <li><a href="#" class="current">待定</a></li>
            <li><a href="#" class="current">待定</a></li>
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
    </div>
</div>
  <!-- End #sidebar -->
  
  
<div class="content-box column-left" style="margin-left: 400">
    <div class="content-box-header">
       	<h3>修改订单信息</h3>
    </div>
      <!-- End .content-box-header -->
    <div class="content-box-content" >
	   	<form action="EditOrder" method="post" style="margin-left: 240">
	   	<table>
	   		<tr>
	   			<td>订单ID：</td>
	   			<td><input type="text" name="orderid" value=<%=orders.getOrderID() %> /> <td>
	   		</tr>
	   		<tr>
	   			<td>保险：</td>
	   			<td>
		   			<select name="insurance">
		   				<option> <%=orders.getInsuranceName() %> </option>
						<option>太平洋保险</option>
						<option>途乐行保险</option>
						<option>平安保险</option>
					</select>
				</td>
	   		</tr>
	   		<tr>
	   			<td>总人数：</td>
	   			<td><input type="text" name="personnum" value=<%=orders.getSumPerson() %> /> <td>
	   		</tr>
	   		<tr>
	   			<td>总价：</td>
	   			<td><input type="text" name="sumprice" value=<%=orders.getSumPrice() %> /> <td>
	   		</tr>
	   		<tr>
	   			<td>折后价：</td>
	   			<td><input type="text" name="finalprice" value=<%=orders.getFinalPrice() %> /> <td>
	   		</tr>
	   		
	   		<tr>
	   			<td colspan="2"><input type="submit" value="确认修改" /></td>
	   		</tr>
	   	</table>
	   	</form> 
	</div>
</div>


</body>
</html>
