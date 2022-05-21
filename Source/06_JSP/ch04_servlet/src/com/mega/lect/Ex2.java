package com.mega.lect;
// 똑같은 이름의 파라미터를 전달해보자! 2파일
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// menu, rest 파라미터 : request.getParameterValue("파라미터이름") => 배열로 받음
		// 파라미터가 안들어오면 null이 들어올 수 있음, 같은 이름 파라미터 여러개 가능
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		
		// nation 파라미터 : request.getParameter("파라미터이름") -> String으로 받음
		String nation = request.getParameter("nation");
		
		//뿌려줄 때 타입 설정(한글로), 스트림 꽂기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		if(menu!=null) {
			out.println("<h4>선택한 메뉴는 </h4>");
			for(String m:menu) {
				out.println(m+" ");
			}
		}else {
			out.println("<h4>선택한 메뉴가 없습니다</h4>");
		}
		if(rest!=null) {
			out.println("<h4>선택한 식당 지역은"+Arrays.toString(rest) + "입니다</h4>"); //for문처럼 뿌려주는거
			
		}else {
			out.println("<h4>선택한 식당이 없습니다</h4>");
		}
		out.println("<h4>선택한 국적은 "+nation+"입니다</h4>");
		out.close(); //스트림 제거
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
