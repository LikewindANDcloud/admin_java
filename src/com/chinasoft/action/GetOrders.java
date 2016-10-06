package com.chinasoft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.CPOrders;
import com.chinasoft.bean.Orders;
import com.chinasoft.dao.OrdersDAO;
import com.chinasoft.service.IOrderService;
import com.chinasoft.service.OrderService;

public class GetOrders extends HttpServlet {

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
		int pageIndex=1,pageSize=5;
		String pageIndexStr=request.getParameter("pageIndex");
		String pageSizeStr=request.getParameter("pageSize");
		String username=request.getParameter("username");
		IOrderService ios=new OrderService();
		if(pageIndexStr!=null&&pageSizeStr!=null&&pageIndexStr!=""&&pageSizeStr!=""){
			pageIndex=Integer.parseInt(pageIndexStr);
			pageSize=Integer.parseInt(pageSizeStr);
		}
		if(username!=null){
			OrdersDAO od=new OrdersDAO();
			List<Orders> list= od.getOrderByUserName(username);
			CPOrders co=ios.getOrders(pageIndex, pageSize,list);
			request.setAttribute("co", co);
			request.getRequestDispatcher("ordermanage.jsp").forward(request, response);
		}else{
			
			CPOrders co=ios.getOrders(pageIndex, pageSize);
			request.setAttribute("co", co);
			request.getRequestDispatcher("ordermanage.jsp").forward(request, response);
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
