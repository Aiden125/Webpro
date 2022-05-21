<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="ex7_output.jsp" method="post">
	<P><h3>로그인화면</h3></P>
		<table>
			<tr>
				<td>이 름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</table>
	</form>	
</body>
</html>