<%@page import="com.lec.ch11.dto.BoardDto"%>
<%@page import="com.lec.ch11.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto boardDto = new BoardDto();
	
	for(int i=0; i<100; i++){
		boardDto.setBname("홍길"+i);
		boardDto.setBtitle("제목"+i);
		boardDto.setBcontent("본문"+i);
		boardDto.setBip("123.123.123.1"+i);
		int result = boardDao.write(boardDto);
		System.out.println(i+"번 째 : "+(result==1? "성공" : "실패"));
	}
	response.sendRedirect("mvcboard/list.do");
%>	
</body>
</html>