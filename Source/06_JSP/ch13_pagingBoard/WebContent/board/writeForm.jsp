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
	<form action="writePro.jsp" method="post">
		<table>
			<caption>게시판</caption>
			<tr>
				<th>작성자</th><!-- 반드시 dto에 있는 데이터 변수명과 똑같이. -->
				<th><input type="text" name="writer" required="required"></th>
			</tr>
			<tr>
				<th>제목</th><!-- 반드시 dto에 있는 데이터 변수명과 똑같이. -->
				<th><input type="text" name="subject" required="required"></th>
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
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" class="btn">
					<input type="reset" value="취소" class="btn">
					<input type="button" value="목록" class="btn"
								onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>















