package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasoft.bean.Admin;
import com.chinasoft.dao.AdminDAO;
import com.chinasoft.dao.InterfaceAdminDAO;
import com.chinasoft.listener.SessionListener;


@SuppressWarnings("serial")
public class CheckAdmin extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String adminname=request.getParameter("adminname");
		String adminpwd=request.getParameter("adminpwd");
		String state=request.getParameter("rememberpwd");
		if(state!=null&&state.equals("on")){
			Cookie ancookie=new Cookie("adminname", adminname);
			Cookie apcookie=new Cookie("adminpwd", adminpwd);
			ancookie.setMaxAge(300000000);
			apcookie.setMaxAge(300000000);
			response.addCookie(apcookie);
			response.addCookie(ancookie);
		}else{
			
		}
		InterfaceAdminDAO iad=new AdminDAO();
		Admin admin=new Admin();
		admin=iad.getLogin(adminname, adminpwd);
		if(admin.getAdminID()!=0){			
			Map<String, HttpSession> loginAdmin=SessionListener.loginAdmin;
			HttpSession session=loginAdmin.get(admin.getAdminNumber());
			if(session!=null){
				System.out.println(session.getId());
				out.print("已登录，不允许重复登录");
				//session.invalidate();
			}else{
				request.getSession().setAttribute("admin", admin);
				out.println("登陆成功，1秒后进入管理界面");
				response.setHeader("Refresh", "1,URL=adminmain.jsp");
			}
		}else{
			out.println("登陆失败，1秒后返回登陆界面");
			response.setHeader("Refresh", "1,URL=adminlogin.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
