package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyViewService;
import com.lec.service.BcontentService;
import com.lec.service.BmodifyService;
import com.lec.service.BmodifyViewService;
import com.lec.service.BwriteService;
import com.lec.service.Service;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
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
		if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/write_view.do")) { // 글쓰기 view
			viewPage = "board/write_view.jsp";
			write_view = true;
		}else if(command.equals("/write.do")){ // 원글쓰기 DB 저장
			if(write_view) {
				service = new BwriteService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")){ // 글 상세보기
			service = new BcontentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
		}else if(command.equals("/modify_view.do")) { // 글 수정을 위한 상세보기페이지
			service = new BmodifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";
		}else if(command.equals("/modify.do")) { // 수정
			service = new BmodifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) { // 삭제(글 DB 삭제)
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) { // 답변글을 위한 정보받기 페이지 view(form태그)
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";
		}else if(command.equals("/reply.do")) { // 답변
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
