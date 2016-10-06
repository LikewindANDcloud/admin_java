<%@page import="com.chinasoft.bean.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>管理员登录</title>
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

</head>
<%	
	Cookie[] cookies=request.getCookies();
	String adminname="";
	String adminpwd="";
	Admin admin=new Admin();
	
			if(cookies!=null){
				for(int i=0;i<cookies.length;i++){
					if(cookies[i].getName().equals("adminname")){
						adminname=cookies[i].getValue();
						admin.setAdminNumber(adminname);
					}
					if(cookies[i].getName().equals("adminpwd")){
						adminpwd=cookies[i].getValue();
						admin.setAdminPwd(adminpwd);
					}
				}
				session.setAttribute("admin", admin);
			}

	
 %>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
   	<h1> 途乐行后台管理系统</h1>
    <!-- Logo (221px width) -->
  </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form action="CheckAdmin" method="post">
      <p>
        <label>Username</label>
        <input class="text-input" id="name" type="text" name="adminname" value="<%=adminname %>" />
      </p>
      <div class="clear"></div>
      <p>
        <label>Password</label>
        <input class="text-input" type="password"  name="adminpwd" value="<%=adminpwd %>"/>
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" name="rememberpwd" id="jzmm" value="on"/>
        Remember me </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="Sign In" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
<script type="text/javascript">
	var name=document.getElementById("name").value;
	if(name!=""){
		document.getElementById("jzmm").checked=true;
	}else{
		
	}
</script>
</body>
</html>
