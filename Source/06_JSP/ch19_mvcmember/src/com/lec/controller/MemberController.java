package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MJoinService;
import com.lec.service.MListService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutSerivce;
import com.lec.service.MModifyService;
import com.lec.service.MModifyViewService;
import com.lec.service.Service;

/**
 * Servlet implementation class CustomerController
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
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null; // forward될 페이지
		Service service = null;
		
		if(command.equals("/joinView.do")) { // 회원가입
			viewPage = "member/joinView.jsp";
		}else if(command.equals("/join.do")) { // 회원가입 DB처리
			service = new MJoinService(); // id중복 체크 후 회원가입
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(command.equals("/loginView.do")) {
			viewPage = "member/loginView.jsp";
		}else if(command.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "mainView.do";
		}else if(command.equals("/mainView.do")) {
			viewPage = "member/mainView.jsp";
		}else if(command.equals("/listView.do")) {
			service = new MListService();
			service.execute(request, response);
			viewPage = "member/listView.jsp";
		}else if(command.equals("/logout.do")) {
			service = new MLogoutSerivce();
			service.execute(request, response);
			viewPage = "mainView.do";
		}else if(command.equals("/modifyView.do")) {
			// service = new MModifyViewService(); // DB에서 회원정보 가져와도 ok
			// service.execute(request, response); // 세션에 dto 넣었으면 없어도 되는 두줄
			viewPage = "member/modifyView.jsp";
		}else if(command.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "mainView.do";
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
