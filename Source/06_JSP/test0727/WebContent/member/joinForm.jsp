<%@page import="com.test.dao.MemberDao"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
<script>
	function chkJoinInfo(){
		if(frmJoin.custname.value==''){
			alert('이름은 필수사항입니다.');
			frmJoin.custname.focus();
			return false;
		}
	}
</script>
</head>
<body>
<%
	MemberDao dao = MemberDao.getInstance();
	int number = dao.number();
%>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<form  action="<%=conPath %>/member/joinPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoinInfo()">
	<table id="table">
		<caption>홈쇼핑 회원 등록</caption>
			<tr>
				<th>회원번호(자동발생)</th>
				<td><input type="text" readonly="readonly" placeholder="<%=number+1%>"></td>
			</tr>
			<tr>
				<th>회원성명</th>
				<td><input type="text" name="custname"></td>
			</tr>
			<tr>
				<th>회원전화</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>회원주소</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><input type="text" name="tempdate" readonly="readonly" placeholder="<%=LocalDate.now()%>"></td>
			</tr>
			<tr>
				<th>고객등급<p>(A:VIP, B:일반, C:직원)</p></th>
				<td><input type="text" name="grade"></td>
			</tr>
			<tr>
				<th>도시코드</th>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="조회" onclick="location.href='<%=conPath%>/member/list.jsp'">
				</td>
			</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>