<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="joinAction.jsp" method="post" onclick="return pChk()">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>