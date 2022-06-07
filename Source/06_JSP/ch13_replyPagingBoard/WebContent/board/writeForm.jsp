<%@page import="com.lec.dao.BoardDao"%>
<%@page import="com.lec.dto.BoardDto"%>
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
<%
	//우선은 초기화해놓기(파라미터 잡기전에)
	int num = 0;
	BoardDto dto = new BoardDto();
	String pageNum = request.getParameter("pageNum"); // 원글쓰기는 pageNum 안들어옴
	if(pageNum==null){ // 원글을 쓰려는거라면
		pageNum = "1";
	}
	if(request.getParameter("num")!=null){ // 답변글을 쓰려는거라면
		num = Integer.parseInt(request.getParameter("num"));
		BoardDao dao = BoardDao.getInstance();
		dto = dao.getBoardOneLine(num); // 원글에 대한 정보 받아오기
		System.out.println("writeForm.jsp에서 원글의 ref : " + dto.getRef());
		System.out.println("writeForm.jsp에서 원글의 re_step : " + dto.getRe_step());
		System.out.println("writeForm.jsp에서 원글의 re_indent : " + dto.getRe_indent());
	}
%>
	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="ref" value="<%=dto.getRef() %>">
		<input type="hidden" name="re_step" value="<%=dto.getRe_step() %>">
		<input type="hidden" name="re_indent" value="<%=dto.getRe_indent() %>">
		<table>
			<caption>게시판</caption>
			<tr>
				<th>작성자</th><!-- 반드시 dto에 있는 데이터 변수명과 똑같이. -->
				<th><input type="text" name="writer" required="required"></th>
			</tr>
			<tr>
				<th>제목</th><!-- 반드시 dto에 있는 데이터 변수명과 똑같이. -->
				<th><input type="text" name="subject" required="required" value="<%
					if(dto.getSubject()!=null){ //답변글인 경우(원글정보 포함해야함)
						out.print("답 : " + dto.getSubject());
					}
				%>"></th>
			</tr>
			<tr>
				<th>이메일</th><!-- 반드시 dto에 있는 데이터 변수명과 똑같이. -->
				<th><input type="email" name="email"></th>
			</tr>
			<tr>
				<th>본문</th>
				<th><textarea rows="5" cols="5" required="required" name="content"></textarea></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn"
								onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>















