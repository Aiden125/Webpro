package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_exam
 */
@WebServlet("/Ex3_exam")
public class Ex3_exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_exam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actionDo 만들어서 하기. 실무에서는 보통 이렇게하는데,
		//일단 원래대로 진행을 하지만 원래 진행하던걸 actionDo에 넣어서 맨 아래로 빼주고 doGet에서는 actionDo를 호출하는 형식으로 깔끔하게 정리하는 방식
		actionDo(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식이 아니라면 안써도 되긴하지만 이게 당연한 폼으로 굳혀진 느낌(post가 웬만해서는 들어가기 때문에)
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String main = request.getParameter("main");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>게시판</h2>");
		out.println("제목 : "+main+"<br>");
		out.println("작성자 : "+writer+"<br>");
		out.println("내용 : "+content);
		out.close();
		
	}

}
