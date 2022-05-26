<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	//세션 키값 가져오기
	Enumeration<String> names = session.getAttributeNames();
	int cnt = 0;
	while(names.hasMoreElements()){
		String sname = names.nextElement(); //세션 이름(키) 담기
		String svalue = (String)session.getAttribute(sname);
		out.println("<h4>"+sname+"(세션속성명(key))" + svalue + "(세션속성값(value))</h4>");
		cnt++;
	}
	if(cnt==0){ //세션이 없는건지 실행이 안된건지 확실히 구분하기 위해 넣어줌
		out.println("<h4>유효한 세션 속성이 없습니다</h4>");
		out.println("<button onclick=\"location.href='login.jsp'\">로그인</button>");
	}else{
		out.println("<button onclick=\"location.href='login.jsp'\">로그아웃</button>");
	}
%>
	<button onclick="history.back()">이전페이지</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
</body>
</html>