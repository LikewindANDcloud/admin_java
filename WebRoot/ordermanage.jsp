<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.chinasoft.bean.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单管理页面</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="css/reset.css" type="text/css"
	media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="css/invalid.css" type="text/css"
	media="screen" />
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
	Object obj = session.getAttribute("admin");
	Admin admin = new Admin();
	if (obj != null) {
		admin = (Admin) obj;
	} else {
		out.print("登录过期，重新登录");
	}
	if (admin.getAdminNumber() == null) {
		response.sendRedirect("prompt.jsp");
	}
%>
<body>
	<div id="body-wrapper">
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<!-- Sidebar with logo and menu -->
				<h1 id="sidebar-title">
					<a href="#">途乐行</a>
				</h1>
				<!-- Sidebar Profile links -->
				<div id="profile-links">
					<h5>
						您好,
						<%=admin.getAdminNumber()%></h5>
				</div>
				<ul id="main-nav">
					<!-- Accordion Menu -->
					<li><a href="Exit" class="nav-top-item no-submenu"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							退出登录
					</a></li>
					<li><a href="GetLine" class="nav-top-item"> <!-- Add the class "current" to current menu item -->
							线路管理
					</a>
						<ul>
							<li><a href="GetLine" class="current">查看线路</a></li>
							<li><a href="#" class="current">待定功能</a></li>
						</ul></li>
					<li><a href="GetOrders" class="nav-top-item current" id="ordermanage">订单管理</a>
						<ul>
							<li><a href="GetOrders" class="current">订单查询</a></li>
							<li><a href="#" class="current">待定功能</a></li>
						</ul></li>
					<li><a href="GetUsers" class="nav-top-item"> 会员管理 </a>
						<ul>
							<li><a href="GetUsers" class="current">所有会员</a></li>
							<li><a href="#" class="current">待定功能</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> 酒店管理 </a>
						<ul>
							<li><a href="#" class="current">酒店查询</a></li>
							<li><a href="#" class="current">待定功能</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> 待定 </a>
						<ul>
							<li><a href="#" class="current">待定</a></li>
							<li><a href="#" class="current">待定</a></li>
						</ul></li>
				</ul>
				<!-- End #main-nav -->
			</div>
		</div>
		<div id="main-content">
			<div class="content-box">
				<div class="content-box-header">
					<h3>所有订单信息</h3>
					<form action="GetOrders" method="post">
						<input type=text name="username" style="margin-top: 10px" /> <input
							type="submit" value="搜索" style="margin-top: 10px" />
					</form>

				</div>
				<!-- end Content Box header-->
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<!-- This is the target div. id must match the href of this div's tab -->
						<table>
							<thead>
								<tr>
									<th>订单编号</th>
									<th>线路名</th>
									<th>顾客名</th>
									<th>人数</th>
									<th>出行日期</th>
									<th>归来日期</th>
									<th>保险</th>
									<th>总价</th>
									<th>最终价</th>
									<th>订单时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="6">
										<div class="pagination">
											<a href="GetOrders?pageIndex=1&pageSize=5" title="First Page">&laquo;
												First</a> <a
												href="GetOrders?pageIndex=${co.pageIndex<=1?1:co.pageIndex-1 }&pageSize=5"
												title="Previous Page">&laquo; Previous</a> <a
												href="GetOrders?pageIndex=${co.pageIndex>=co.pageCount?co.pageCount:co.pageIndex+1 }&pageSize=5"
												title="Next Page">Next &raquo;</a> <a
												href="GetOrders?pageIndex=${co.pageCount }&pageSize=5"
												title="Last Page">Last &raquo;</a>
										</div> <!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="order" items="${co.list }" varStatus="status">
									<tr>
										<td>${order.orderID }</td>
										<td>${order.lineName }</td>
										<td>${order.userName }</td>
										<th>${order.sumPerson }</th>
										<td>${order.outDate }</td>
										<td>${order.returnDate }</td>
										<td>${order.insuranceID }</td>
										<td>${order.sumPrice }</td>
										<td>${order.finalPrice }</td>
										<td>${order.orderTime }</td>
										<td>
											<!-- Icons --> <a
											href="editorders.jsp?orderid=${order.orderID }" title="修改"><img
												src="img/icons/pencil.png" alt="Edit" /></a> <a
											href="DeleteOrders?orderid=${order.orderID }" title="删除"><img
												src="img/icons/cross.png" alt="Delete" /></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- End #tab1 -->

				</div>

			</div>
		</div>
	</div>
</body>
</html>
