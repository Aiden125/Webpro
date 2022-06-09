package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiddenParam  = request.getParameter("hiddenParam");
		String name 		= request.getParameter("name");
		String id 			= request.getParameter("id");
		String pw 			= request.getParameter("pw"); //pw, pwChk가 같으니까 넘어왔을것이기에 pwChk는 따로 안잡아줌
		String birth 		= request.getParameter("birth");
		Date birth2=null;
		Timestamp birth3=null;
		if(birth!="") {
			birth2			= Date.valueOf(request.getParameter("birth"));
			birth3	= Timestamp.valueOf(request.getParameter("birth") + " 00:00:00"); //날짜만 오면 안되고 시간도 같이 와야하기에 00 부분 추가해줌
		}
		String[] hobby		= request.getParameterValues("hobby"); //배열이거나 null이거나(html에서 분류 안해줬기에)
		String gender		= request.getParameter("gender");
		String email 		= request.getParameter("email");
		String[] mailSend 	= request.getParameterValues("mailSend"); //배열이면서, null 안됨
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		// link href='../css.join.css' rel='stylesheet'>
		out.println("<link href='/ch04_servlet/css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<h2>hiddenParam = "+hiddenParam+"</h2>");
		out.println("<h2>이름 : "+name+"</h2>");
		out.println("<h2>아이디 : "+id+"</h2>");
		out.println("<h2>비밀번호 : ");
		for(int i=0; i<pw.length(); i++) {
			out.println('*');
		}
		out.println("</h2>");
		out.println("<h2>생년월일 : " + birth + "</h2>");
		out.println("<h2>생년월일(java.sql.Date) : " +birth2 + "</h2>");
		out.println("<h2>생년월일(java.sql.Timestamp) : " +birth3+"</h2>");
		out.println("<h2>취미 : "); //취미 : 요리, 운동
		if(hobby!=null) {
			for(int i=0; i<hobby.length; i++) {
				if(i == hobby.length-1) {
					out.println(hobby[i]);
				}else {
					out.println(hobby[i] + ", ");
				}
			}
		}else {
			out.println("선택된 취미가 없음");
		}
		out.println("</h2>");
		out.println("<h2>성별 : " + gender + "</h2>");
		out.println("<h2>이메일 : " + email + "</h2>");
		out.println("<h2>메일 수신 동의 : " + Arrays.toString(mailSend) + "</h2>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

}
