package com.chinasoft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.bean.CPLines;
import com.chinasoft.bean.Lines;
import com.chinasoft.dao.LinesDAO;
import com.chinasoft.service.ILineService;
import com.chinasoft.service.LineService;

public class GetLine extends HttpServlet {

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
		String pageIndexStr=request.getParameter("pageIndex");
		String pageSizeStr=request.getParameter("pageSize");
		String linename=request.getParameter("linename");
		if(pageIndexStr!=null&&pageSizeStr!=null&&pageIndexStr!=""&&pageSizeStr!=""){
			pageIndex=Integer.parseInt(pageIndexStr);
			pageSize=Integer.parseInt(pageSizeStr);
		}
		if(linename!=null){
			LinesDAO ld=new LinesDAO();
			List<Lines> list=ld.getList(linename);
			ILineService ils=new LineService();
			CPLines cl= ils.getLine(pageIndex, pageSize,list);
			request.setAttribute("cl", cl);
			request.getRequestDispatcher("linemanage.jsp").forward(request, response);
		}else{
			ILineService ils=new LineService();
			CPLines cl= ils.getLine(pageIndex, pageSize);
			request.setAttribute("cl", cl);
			request.getRequestDispatcher("linemanage.jsp").forward(request, response);
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
