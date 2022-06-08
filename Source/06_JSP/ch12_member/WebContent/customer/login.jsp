<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
	//name세션이 null이 아니란건 로그인 했다는 것
	if(session.getAttribute("customer")!=null){ 
		response.sendRedirect("loginPro.jsp");
	}
	String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
if(msg!=null){
%>
	<script>
		alert('<%=msg%>');
	</script>
<%
}
%>
<jsp:include page="header.jsp"/>
	<div id="loginForm_wrap">
		<div id="login_title">로그인</div>
		<form action="loginPro.jsp" method="post">
			<table>
				<tr>
					<td> </td><!-- 빈공간 할당  -->
				</tr>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="cid" id="cid"
						required="required" autofocus="autofocus"
						value="<%
					String cid = (String)session.getAttribute("cid");
					if(cid!=null) {
						out.print(cid);
					}
				%>"></td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" required="required"></td>
				</tr>
				<tr>
					<td> </td><!-- 빈공간 할당 -->
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" class="loginBtn_style">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<%
							msg = request.getParameter("msg");
							if(msg!=null){
						%>
							<p id="login_findIdPw" onclick="alert('미 구현 기능입니다');">
							아이디/비밀번호를 잊으셨나요?
							</p>	
						<%	
							}
						%>
					</td>
				</tr>
			</table>
			<p id="login_join">회원이 아닙니다. 회원가입 진행해주세요<a href="join.jsp"> 회원가입</a></p>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>


