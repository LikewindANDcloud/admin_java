package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.CPUsers;
import com.chinasoft.dao.InterfaceUsersDAO;
import com.chinasoft.dao.UsersDAO;
import com.chinasoft.service.IUserService;
import com.chinasoft.service.UsersService;

public class GetUsers extends HttpServlet {

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
		int pageIndex=1,pageSize=5;
		String tj=request.getParameter("tj");
		String value=request.getParameter("value");
		String value_1=request.getParameter("value_1");
		String value_2=request.getParameter("value_2");
		InterfaceUsersDAO iud=new UsersDAO();
		IUserService ius=new UsersService();
		String sql="";
		CPUsers cu=new CPUsers();
		if(value!=null){
			if(tj.equals("用户名")){
				sql="select * from users u,vipTitle v, (select users.userID, count(*) 订单量 from users,orders where users.userID=orders.userID group by users.userID) a where u.userID=a.userID and u.vipID=v.vipID and userNumber like '%"+value+"%'";
				cu=ius.getUsers(pageIndex, pageSize, iud.getList(sql));
				
			}else{
				if(value_1!=null&&value_2!=null){
					sql="select * from users u,vipTitle v, (select users.userID, count(*) 订单量 from users,orders where users.userID=orders.userID group by users.userID) a where u.userID=a.userID and u.vipID=v.vipID and a.订单量>"+value_1+" and a.订单量<"+value_2+"";
					cu=ius.getUsers(pageIndex, pageSize, iud.getList(sql));
				}
			}
		}else{
			sql="select * from users u,vipTitle v, (select users.userID, count(*) 订单量 from users,orders where users.userID=orders.userID group by users.userID) a where u.userID=a.userID and u.vipID=v.vipID ";
			cu=ius.getUsers(pageIndex, pageSize, iud.getList(sql));
		}
		request.setAttribute("cu", cu);
		request.setAttribute("tj", tj);
		request.getRequestDispatcher("usermanage.jsp").forward(request, response);
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
