package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_gugudanOut
 */
@WebServlet(name = "Ex3", urlPatterns = { "/Ex3" })
public class Ex3_gugudanOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_gugudanOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get으로 받아올거기 때문에 doGet에만 써주면 됨
		//파라미터 날라오는거 su 변수로 잡아주기
		int su = Integer.parseInt(request.getParameter("su"));
		response.setContentType("text/html; charset=utf-8");
		
		//스트림 열어주기
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		
		// <link href="/ch03_semiServlet/css/ex3.css" rel="stylesheet">
		// 더블 커테이션 넣는거 주의. 역슬래쉬 들어가야됨
		out.println("<link href=\"/ch03_semiServlet/css/ex3.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>"+su+"단 구구단 입니다</h3>");
		for(int i=1 ; i<=9; i++) {
			out.printf("<p>%d * %d = %d</p>", su, i , su*i);
		}
		out.println("</body>");
		out.println("</html>");
		
		//스트림 닫아주기
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
