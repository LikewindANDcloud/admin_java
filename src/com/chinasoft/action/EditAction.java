package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.Lines;
import com.chinasoft.dao.LinesDAO;

public class EditAction extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Lines line=new Lines();
		line.setLineID(Integer.parseInt(request.getParameter("lineid")));
		line.setLineName(request.getParameter("linename"));
		line.setBeforePrice(Double.parseDouble(request.getParameter("bprice")));
		line.setNowPrice(Double.parseDouble(request.getParameter("nprice")) );
		line.setOutTypeTitle(request.getParameter("sel"));
		LinesDAO ld=new LinesDAO();
		int a=ld.getUpdateLine(line);
		if(a>0){
			out.print("修改成功,3秒后返回主页");
			response.setHeader("Refresh", "3,URL=adminmain.jsp");
		}else{
			out.print("修改失败");
			response.setHeader("Refresh", "3,URL=editline.jsp");
		}
//		out.print(request.getParameter("sel"));
//		out.print(request.getParameter("lineid"));
//		out.print(request.getParameter("linename"));
//		out.print(Double.parseDouble(request.getParameter("bprice")));
//		out.print(Double.parseDouble(request.getParameter("nprice")));
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
