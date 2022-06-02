<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"/>
	<div id="loginForm_wrap">
		<div id="login_title">로그인</div>
		<form action="loginAction.jsp" method="post">
			<table>
				<tr>
					<td> </td><!-- 빈공간 할당  -->
				</tr>
				<tr>
					<th><label for="id">닉네임</label></th>
					<td><input type="text" name="id" id="id"
						required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" required="required"></td>
				</tr>
				<tr>
					<td> </td><!-- 빈공간 할당 -->
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="loginBtn_style">
					</td>
				</tr>
			</table>
			<p id="login_join">회원이 아닙니다. 회원가입 진행해주세요<a href="<%=conPath %>/join.jsp"> 회원가입</a></p>
		</form>
	</div>
</body>
</html>


