package com.mega.lect;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id, pw 파라미터 잡아오기(request.getPara)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 브라우저에 뿌리기.(응답+타입 response.setContent)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();		
		out.print("<h2>아이디 : " +id+"</h2>");
		out.print("<h2>비밀번호 : " +pw+"</h2>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //request 파라미터의 한글 처리
		doGet(request, response);
	}

}
