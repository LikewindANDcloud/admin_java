package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.Users;
import com.chinasoft.dao.InterfaceUsersDAO;
import com.chinasoft.dao.UsersDAO;

public class RegistAction extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String userpwd=request.getParameter("pwd");
		String truename=request.getParameter("truename");
		String phonenumber=request.getParameter("phonenumber");
		String idnumber=request.getParameter("idnumber");
		String gender=request.getParameter("gender");
		Users user=new Users();
		user.setUserNumber(username);
		user.setUserPwd(userpwd);
		user.setUserName(truename);
		user.setUserTel(phonenumber);
		user.setUserIdentity(idnumber);
		user.setUserSex(gender);
		user.setVipID(1);
		InterfaceUsersDAO iud=new UsersDAO();
		int a=iud.getRegUsers(user);
		if(a>0){
			out.println("×¢²á³É¹¦£¬3Ãëºó·µ»ØµÇÂ¼");
			response.setHeader("Refresh", "3,URL=foot.jsp");
		}else{
			out.println("×¢²áÊ§°Ü£¬3Ãëºó·µ»ØÖØÐÂ×¢²á");
			response.setHeader("Refresh", "3,URL=regist.jsp");
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
