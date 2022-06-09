<%@page import="com.lec.book.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>

					<!-- 등록되어 있는 책들의 리스트 조회 -->
	
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
<%
	BookDao bDao = BookDao.getInstance();
	ArrayList<BookDto> books = bDao.listBook();
%>
	<table>
		<caption>책 리스트</caption>
		<tr>
			<th>책ID</th>
			<th>책이름</th>
			<th>책대표이미지</th>
			<th>책가격</th>
			<th>할인률</th>
		</tr>
		<%if(books.size()==0){
			out.println("<tr><td colspan='5'>등록된 책이 없습니다</td></tr>");
		}else {
			for(BookDto book : books){
				out.println("<tr><td>"+book.getBid()+"</td><td>"+book.getBtitle()+"</td>");
				out.println("<td><img src='../bookimg/"+book.getBimage1()+"' width='15'></td>");
				out.println("<td>"+book.getBprice()+"</td><td>"+book.getBdiscount()+"</td></tr>");
			}
		}
			
			%>
	</table>
</body>
</html>