package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lec.service.MidCheckService;
import com.lec.service.MjoinService;
import com.lec.service.MemailCheckService;
import com.lec.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/idCheck.do")) {
			service = new MidCheckService();
			service.execute(request, response);
			viewPage = "member/idCheck.jsp";
		}else if(command.equals("/emailCheck.do")) {
			service = new MemailCheckService();
			service.execute(request, response);
			viewPage = "member/emailCheck.jsp";
		}else if(command.equals("/join.do")) {
			service = new MjoinService();
			service.execute(request, response);
			viewPage = "member/loginView.jsp";
		}else if(command.equals("/loginView.do")) {
			viewPage = "member/loginView.jsp";
		}else if(command.equals("/joinView.do")) {
			viewPage = "member/joinView.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
