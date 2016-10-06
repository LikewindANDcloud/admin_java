package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.Orders;
import com.chinasoft.dao.InsuranceDAO;
import com.chinasoft.dao.OrdersDAO;

public class EditOrder extends HttpServlet {

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
		response.setContentType("text/html;charset:utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		InsuranceDAO id=new InsuranceDAO();
		String orderid=request.getParameter("orderid");
		String insurname=request.getParameter("insurance");
		String personnum=request.getParameter("personnum");
		String sumprice=request.getParameter("sumprice");
		String finalprice=request.getParameter("finalprice");
		Orders order=new Orders();
		OrdersDAO od=new OrdersDAO();
		int insuranceid=id.getInsurId(insurname);
		order.setOrderID(Integer.parseInt(orderid));
		order.setInsuranceID(insuranceid);
		order.setSumPerson(Integer.parseInt(personnum));
		order.setSumPrice(Double.parseDouble(sumprice));
		order.setFinalPrice(Double.parseDouble(finalprice));
		int a=od.updateOrder(order);
		if(a>0){
			out.print("更新成功；1秒后返回");
			response.setHeader("Refresh", "1,URL=GetOrders");
		}else{
			out.print("更新失败；1秒后返回");
			response.setHeader("Refresh", "1,URL=GetOrders");
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
