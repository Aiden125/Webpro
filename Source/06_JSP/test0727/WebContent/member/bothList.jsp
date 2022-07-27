<%@page import="com.test.dto.MemberDto"%>
<%@page import="com.test.dao.MemberDao"%>
<%@page import="com.test.dto.MoneyDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.dao.MoneyDao"%>
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
			<th>고객등급</th>
			<th>매출</th>
		</tr>
	
	<%
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> mdtos = mDao.listMemberSal();
		if(mdtos.isEmpty()){
			out.println("<tr><td colspan='4'>판매 데이터가 없습니다</td></tr>");
		}else{
			for(MemberDto d : mdtos){
	%>
			<tr>
				<td><%=d.getCustno() %></td>
				<td><%=d.getCustname() %></td>
				<td><%=d.getLevel_name() %></td>
				<td><%=d.getSum_price() %></td>
			</tr>
	<%			
			}
		}
	%>
	</table>



	<table id="table">
		<tr>
			<th>제품코드</th>
			<th>매출</th>
		</tr>
	
	<%
		MoneyDao moDao = MoneyDao.getInstance();
		ArrayList<MoneyDto> modtos = moDao.listProduct();
		if(modtos.isEmpty()){
			out.println("<tr><td colspan='2'>판매 데이터가 없습니다</td></tr>");
		}else{
			for(MoneyDto d : modtos){
	%>
			<tr>
				<td><%=d.getPcode() %></td>
				<td><%=d.getSum() %></td>
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