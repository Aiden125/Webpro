<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%! String id, pw; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	// 입력받은 id, pw가 DB에 있는지 확인 절차
	if(id!=null && id.equals("aaa") && pw!=null && pw.equals("111")){
		// 로그인처리
		Cookie idCookie = new Cookie("id", id); // id쿠키 생성
		idCookie.setMaxAge(-1); //유효시간(-1) == 로그아웃 할 때 까지
		response.addCookie(idCookie);
		Cookie nameCookie = new Cookie("name", "홍길동"); // 이름쿠키 생성 DB에서 가져온 이름을 쿠키값으로
		nameCookie.setMaxAge(-1);
		response.addCookie(nameCookie);
		response.sendRedirect("welcome.jsp");
	}else{
%>
	<script>
		alert("아이디와 비밀번호를 확인하세요");
		location.href="login.html";
	</script>
<%		
	}
%>
	
</body>
</html>