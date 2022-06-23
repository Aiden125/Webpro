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
import com.lec.service.MlistViewService;
import com.lec.service.MloginService;
import com.lec.service.MlogoutService;
import com.lec.service.MmodifyService;
import com.lec.service.MmodifyViewService;
import com.lec.service.FWriteService;
import com.lec.service.FWriteViewService;
import com.lec.service.FcontentViewService;
import com.lec.service.FlistViewService;
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
		}else if(command.equals("/mainView.do")) {
			viewPage = "member/mainView.jsp";
		}else if(command.equals("/login.do")) {
			service = new MloginService();
			service.execute(request, response);
			viewPage = "/mainView.do";
		}else if(command.equals("/logout.do")) {
			service = new MlogoutService();
			service.execute(request, response);
			viewPage = "/mainView.do";
		}else if(command.equals("/modifyView.do")) {
			service = new MmodifyViewService();
			service.execute(request, response);
			viewPage = "member/modifyView.jsp";
		}else if(command.equals("/modify.do")) {
			service = new MmodifyService();
			service.execute(request, response);
			viewPage = "/mainView.do";
		}else if(command.equals("/listView.do")) {
			service = new MlistViewService();
			service.execute(request, response);
			viewPage = "member/listView.jsp";
		}else if(command.equals("/fListView.do")) {
			service = new FlistViewService();
			service.execute(request, response);
			viewPage = "board/listView.jsp";
		}else if(command.equals("/fContentView.do")) {
			service = new FcontentViewService();
			service.execute(request, response);
			viewPage = "board/contentView.jsp";
		}else if(command.equals("/fWriteView.do")) {
			viewPage = "board/writeView.jsp";
		}else if(command.equals("/fWrite.do")) {
			service = new FWriteService();
			service.execute(request, response);
			viewPage = "/fListView.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
