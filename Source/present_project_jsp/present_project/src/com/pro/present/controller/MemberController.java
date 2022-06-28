package com.pro.present.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.present.service.MjoinService;
import com.pro.present.service.MloginService;
import com.pro.present.service.Service;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // /ch19_mvcboard/list.do
		String conPath = request.getContextPath(); // /ch19_mvcboard
		String command = uri.substring(conPath.length()); // /list.do
		String viewPage = null;
		Service service = null;
		if(command.equals("/loginView.do")) {
			viewPage = "member/loginView.jsp";
		}else if(command.equals("/joinView.do")) {
			// service = new MjoinService();
			// service.execute(request, response);
			viewPage = "member/joinView.jsp";
		}else if(command.equals("/login.do")) {
			service = new MloginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
