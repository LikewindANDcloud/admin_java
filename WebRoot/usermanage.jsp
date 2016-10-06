<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.chinasoft.bean.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>会员管理页面</title>
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
        <li> <a href="GetOrders" class="nav-top-item" >订单管理</a>
          <ul>
            <li><a href="GetOrders" class="current" >订单查询</a></li>
            <li><a href="#" class="current">待定功能</a></li>
          </ul>
        </li>
        <li> <a href="GetUsers" class="nav-top-item current"> 会员管理 </a>
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
  <div id="main-content">
    <div class="content-box" id="l" >
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>所有用户信息</h3>
        <form action="GetUsers" method="post">
        <select name="tj" id="tj" ><option>用户名</option><option>订单量范围</option></select>
        	<span id="1">
        	<input type=text name="value"  style="margin-top: 10px" />
        	<input type="submit" value="搜索" style="margin-top: 10px" />
        	</span>
        	<span id="2" style="display: none">
        	大于<input type=text name="value_1" style="margin-top: 10px" />
        	小于<input type=text name="value_2"  style="margin-top: 10px" />
        	<input type="submit" value="搜索" style="margin-top: 10px" />
        	</span>
        </form>
      </div>
      <!-- End .content-box-header -->
      
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
          <!-- This is the target div. id must match the href of this div's tab -->
          <form action="UpdateAll" method="post">
          <table>
            <thead>
              <tr>
              	<th><input type="button" value="全不选" id="checkNone"/></th>
                <th>用户编号</th>
                <th>用户名</th>
                <th>用户电话</th>
                <th>性别</th>
                <th>会员等级</th>
                <th>订单量</th>
                <th>操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="5">
                  <div class="pagination"> 
                  <a href="GetUsers?pageIndex=1&pageSize=5" title="First Page">&laquo; First</a>
                  <a href="GetUsers?pageIndex=${cu.pageIndex<=1?1:cu.pageIndex-1 }&pageSize=5" title="Previous Page">&laquo; Previous</a>
                  <a href="GetUsers?pageIndex=${cu.pageIndex>=cu.pageCount?cu.pageCount:cu.pageIndex+1 }&pageSize=5" title="Next Page">Next &raquo;</a>
                  <a href="GetUsers?pageIndex=${cu.pageCount }&pageSize=5" title="Last Page">Last &raquo;</a> 
                  </div>
                  <!-- End .pagination -->
                </td>
              </tr>
            </tfoot>
            <tbody>
            <c:forEach var="users" items="${cu.list }" varStatus="status">
              <tr>
              	<td><input type="checkbox" name="ids" value=${users.userID } /></td>
                <td >${users.userID } </td>
                <td>${users.userNumber }</td>
                <td>${users.userTel }</td>
                <td>${users.userSex }</td>
                <td>${users.userVipTitle }</td>
                <td>${users.orderNum } </td>
               
                <td>
                  <!-- Icons -->
                  <a href="#" title="修改"><img src="img/icons/pencil.png" alt="Edit" /></a> 
                  <a href="#" title="删除"><img src="img/icons/cross.png" alt="Delete" /></a> 
                  <a href="#" title="新增"><img src="img/icons/add.jpg" alt="Edit Meta" /></a> 
                </td>
              </tr>
            </c:forEach>
            <tr>
            <td><input type="button" value="全选" id="checkAll"/></td>
            <td colspan="6"></td>
            <td><input type="submit" value="升级"/></td>
            </tr>
            </tbody>
          </table>
          </form>
        </div>
      </div>
    </div>
  </div>
  </div>
  <script type="text/javascript">
$(function(){
	$("#checkAll").click(function(){
		$('[name=ids]:checkbox').attr('checked',true);
	});
	$("#checkNone").click(function(){
		$('[type=checkbox]:checkbox').attr('checked',false);
	});
	$("#tj").change(function(){
		var tj=document.getElementById("tj").value;
		if(tj=="用户名"){
			$("#2").hide();
			$("#1").show();
		}else{
			$("#2").show();
			$("#1").hide();
		}
	});
});
</script>
  </body>
</html>
