<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<a href="xx.jsp">xx</a> <!-- 404에러 유도 -->
<%--
	BoardDao bDao = BoardDao.getInstance();
	
	//1번 test : 글 갯수 출력
	out.println("<h2>1. DB 글 갯수 : " + bDao.getBoardTotalCnt()+"입니다</h2>");
	
	//2번 test : 글 목록 출력
	out.println("<h2>2. 글 목록 : </h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for(BoardDto dto : dtos){
		out.println(dto + "<br>");
	}
	
	//3번 test : 글 쓰기
	out.println("<h2>3. 글 쓰기 : </h2>");
	BoardDto dto = new BoardDto(0, "김기동", "글제목n", "글본문", null, 0, "111", 0, 0, 0, "127.0.0.2", null);
	int result = bDao.insertBoard(dto);
	out.println(result == BoardDao.SUCCESS? "글쓰기 성공" : "글쓰기 실패");
	
	//4,5번 test : 조회수 올리고 글번호로 dto가져오기
	out.println("<h2>4, 5번 : 조회수 올리고 글번호로 dto가져오기</h2>");
	out.println("수정전의 5번글 "+dto);
	bDao.readcountUpt(5);
	dto = bDao.getBoardOneLine(5);
	out.println(dto);
	
	//6번 test : 글 수정
	out.println("<h2>6. 글 수정 : </h2>");
	dto.setSubject("바뀐 제목xxxxxx");
	dto.setContent("바뀐 본문yyyyyyy");
	result = bDao.updateBoard(dto);
	if(result == BoardDao.SUCCESS){
		dto = bDao.getBoardOneLine(5);
		out.println("수정 후의 5번 글" + dto);
	}else{
		out.println("수정 실패");
	}
	
	//7번 test : 글 지우기
	out.println("<h2>7. 5번글 삭제</h2>");
	result = bDao.deleteBoard(5, "1111");
	out.println(result==bDao.SUCCESS ? "5번글 삭제성공" : "5번글 삭제실패");
	result = bDao.deleteBoard(5, "111");
	out.println(result==bDao.SUCCESS ? "5번글 삭제성공" : "5번글 삭제실패");
--%>	
</body>
</html>