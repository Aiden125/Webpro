<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<%=conPath %>/css/join.css' rel='stylesheet'>
</head>
<body>
<%!
	String cid, ctel, cname, cgender, cemail, caddress;
	Date cbirth;
%>
<%
	request.setCharacterEncoding("utf-8");
	CustomerDto customer = (CustomerDto)session.getAttribute("customer"); //멤버 세션으로 로그인되었는지 확인
	if(customer==null){ //customer 세션이 없다? 로그인 안한 것
		response.sendRedirect("login.jsp");
	}else{ //세션이 있는경우(로그인 한 것)
		cid = customer.getCid();
		ctel = customer.getCtel();
		cname = customer.getCname();
		cgender = customer.getCgender();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cbirth = customer.getCbirth();
	}
%>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
		<form action="modifyPro.jsp" method="post" name="frmJoin" onsubmit="return chkJoinInfo()">
			<div id="join_title">정보수정</div>
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td><input type="text" name="cid" id="cid" class="cid" value="<%=cid %>" readonly="readonly"></td>
				</tr>
				<tr>
					<th><label for="oldPw">현비밀번호</label></th>
					<td><input type="password" name="oldPw" id="oldPw" class="cpw" required="required"></td>
				</tr>
				<tr>
					<th><label for="cpw">새비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw" class="cpw" placeholder="비밀번호 수정 원할시만 입력"></td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td><input type="text" name="cname" id="cname" class="cname" value="<%=cname %>" required="required"></td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td><input type="text" name="ctel" id="ctel" class="ctel" value="<%=ctel %>"required="required" placeholder="010-"></td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td><input type="email" name="cemail" id="cemail" class="cemail" value='<%=cemail==null? "":cemail %>' ></td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td><input type="text" name="caddress" id="caddress" class="caddress" value="<%=cname %>"></td>
				</tr>
				<tr>
					<th><label for="tempbirth">생년월일</label></th>
					<td><input type="date" name="tempbirth" id="tempbirth" class="tempbirth" value='<%=cbirth==null? "":cbirth %>' required="required"></td>
				</tr>

				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" value="m" checked="checked" id="m"><label for="m">남자</label>
						<input type="radio" name="cgender" value="f" id="f"><label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<td colspan="2"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="이전으로" class="joinBtn_style" 
											onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
