package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2_suOut
 */
@WebServlet(name = "Ex2suOut", description = "sumOut", urlPatterns = { "/Ex2suOut" })
public class Ex2_suOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2_suOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.getParameter("num");
		
		// 페이징 기법
		if(numStr==null || numStr.equals("")) {
			numStr = "1";
		}
		int num = Integer.parseInt(numStr);
		int sum = 0;
		for(int i=0; i<=num; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>1부터" + num+"까지 누적합은"+sum+"입니다</h1>");
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
