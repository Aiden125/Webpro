package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청이(/Ex3, /insert.do /delete.do /update.do)들어왔는지
		String conPath  = request.getContextPath(); // conPath = "/ch05_jsp"
		String uri 		= request.getRequestURI(); // uri = "/ch05_jsp/Ex3" uri에서 - conPath 하면 /Ex3만 남은
		String command	= uri.substring(conPath.length());
		System.out.println("conPath = " + conPath);
		System.out.println("uri = " + uri);
		System.out.println("command = " + command);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
