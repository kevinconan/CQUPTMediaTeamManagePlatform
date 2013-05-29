/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cqupt.mt2013.cmtmp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cqupt.mt2013.cmtmp.model.*;;

/**
 *
 * @author 廖渝瀚
 * @version 1.0
 * 登陆处理servlet
 */
public class Login extends HttpServlet {

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 * <p/>
	 * @param request  servlet request
	 * @param response servlet response
	 * <p/>
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String userid = request.getParameter("userid");
		System.out.println(userid);
		String password = request.getParameter("password");
		String from = request.getParameter("from");
		//if (from == null | from.equals("null")) {
	//		from = "index.jsp";
	//	}

		UserBeanOp ubo=new UserBeanOp();

		if (ubo.checkUser(userid, password)) {
			System.out.println("ok");
			//request.getSession().setAttribute("loginInfo", bcb);
			request.getRequestDispatcher("index.jsp?ok=1").forward(request, response);

		} else {
			System.out.println("faliure");
			request.getRequestDispatcher("index.jsp?ok=0").forward(request, response);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 * <p/>
	 * @param request  servlet request
	 * @param response servlet response
	 * <p/>
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 * <p/>
	 * @param request  servlet request
	 * @param response servlet response
	 * <p/>
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 * <p/>
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
