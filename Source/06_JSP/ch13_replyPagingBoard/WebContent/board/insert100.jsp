<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
<%
	// 임의로 글들 insert하기(원글)
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=1; i<=70; i++){
		dto.setWriter("홍길동"+i);
		dto.setSubject("제목"+i);
		dto.setContent("본문"+i);
		dto.setEmail("n@n"+i);
		dto.setPw("1234");
		dto.setIp("192.168.10."+i);
		//출력을 원하지 않는다면 result에 안담아도 됨
		//dao.insertBoard(dto);만 하면 끝
		int result = dao.insertBoard(dto);
		System.out.println(result==BoardDao.SUCCESS? i+"번째 글쓰기 성공":i+"번째 글쓰기 실패");
	}
	response.sendRedirect("list.jsp");
%>	
</body>
</html>












