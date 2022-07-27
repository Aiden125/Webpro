<%@page import="com.test.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
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
<body>
<jsp:include page="../main/header.jsp"/>

<div id="content">
	<table id="table">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>회원전화</th>
			<th>주소</th>
			<th>가입일</th>
			<th>고객등급</th>
			<th>도시코드</th>
		</tr>
	
	<%
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> dtos = mDao.listMember();
		if(dtos.isEmpty()){
			out.println("<tr><td colspan='7'>회원이 없습니다</td></tr>");
		}else{
			for(MemberDto d : dtos){
	%>
			<tr>
				<td><a href="<%=conPath%>/member/modifyForm.jsp?custno=<%=d.getCustno() %>"><%=d.getCustno() %></a></td>
				<td><%=d.getCustname() %></td>
				<td><%=d.getPhone() %></td>
				<td><%=d.getAddress() %></td>
				<td><%=d.getJoindate() %></td>
				<td><%=d.getGrade() %></td>
				<td><%=d.getCity() %></td>
			</tr>
	<%			
			}
		}
	%>
	</table>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>