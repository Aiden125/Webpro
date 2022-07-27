<%@page import="com.test.dto.MemberDto"%>
<%@page import="com.test.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<jsp:include page="../main/header.jsp"/>

<body>
<%
	request.setCharacterEncoding("utf-8");
	int custno = Integer.parseInt(request.getParameter("custno"));
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(custno);
%>
	
<div id="content">
	<form  action="<%=conPath %>/member/modifyPro.jsp" method="post">
	<table id="table">
		<caption>홈쇼핑 회원 정보 수정</caption>
			<tr>
				<th>회원번호(자동발생)</th>
				<td><input type="text" name="custno" readonly="readonly" value="<%=dto.getCustno()%>"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname" value="<%=dto.getCustname()%>"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone" value="<%=dto.getPhone()%>"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address" value="<%=dto.getAddress()%>"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="text" name="tempdate" value="<%=dto.getJoindate()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>고객등급<p>(A:VIP, B:일반, C:직원)</p></th>
				<td><input type="text" name="grade" value="<%=dto.getGrade()%>"></td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city" value="<%=dto.getCity()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="button" value="조회" onclick="location.href='<%=conPath%>/member/list.jsp'">
				</td>
			</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>