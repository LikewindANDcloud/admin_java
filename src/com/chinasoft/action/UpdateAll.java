package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.dao.InterfaceUsersDAO;
import com.chinasoft.dao.UsersDAO;
import com.chinasoft.service.IUserService;

public class UpdateAll extends HttpServlet {

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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String[] ids=request.getParameterValues("ids");
		InterfaceUsersDAO iud=new UsersDAO();
		int a=0;
		int vipId=0;
		for(int i=0;i<ids.length;i++){
			if(iud.getOrderNumById(Integer.parseInt(ids[i]))>1&&iud.getOrderNumById(Integer.parseInt(ids[i]))<3){
				vipId=2;
				a+=iud.updateUsers(Integer.parseInt(ids[i]), vipId);
			}else{
				
			}
		}
		if(a==ids.length){
			out.print("全部升级完毕，1秒后返回");
			response.setHeader("Refresh", "3,URL=GetUsers");
		}else{
			out.print("升级失败");
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
