package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Ex1_exam
 */
@WebServlet("/Ex1_exam")
public class Ex1_exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_exam() {
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
		request.setCharacterEncoding("utf-8");//post방식이 아니라면 안써도 되긴하지만 이게 당연한 폼으로 굳혀진 느낌(post가 웬만해서는 들어가기 때문에)
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String[] suStr = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
				
		int[] su = new int[suStr.length];
		for(int i=0; i<suStr.length; i++) {
			su[i] = Integer.parseInt(suStr[i]);
		}
		for(int j=0; j<su.length; j++) {
			out.println(su[j]+"단");
			for(int i=1; i<=9; i++) {
				out.println("<p>"+su[j]+"*"+i+"="+su[j]*i+"</p>");
			}
			out.println("<br>");
		}
		out.close();
	}
}
