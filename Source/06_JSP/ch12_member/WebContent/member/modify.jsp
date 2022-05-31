<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
	<script src="<%=conPath %>/js/modify.js"></script> <!-- 스크립트 로딩 -->
</head>
<body>
<!-- 꼭 여기처럼 선언부를 통해 변수를 미리 선언하지 않아도 괜찮다. -->
<!-- 선언부에 해놓으면 null값이 자동으로 들어가서 편하다. 그냥 스트립트릿에 하면 쓰레기값이 들어감 -->
<%! String id, name, phone1, phone2, phone3, gender, email, address; Timestamp birth; %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDto member = (MemberDto)session.getAttribute("member"); //멤버 세션으로 로그인되었는지 확인
	if(member==null){ //멤버 세션이 없다? 로그인 안한 것
		response.sendRedirect("login.jsp");
	}else{ //멤버 세션이 있는경우(로그인 한 것)
		id = member.getId();
		name = member.getName();
		phone1 = member.getPhone1();
		phone2 = member.getPhone2();
		phone3 = member.getPhone3();
		gender = member.getGender();
		email = member.getEmail();
		address = member.getAddress();
		birth = member.getBirth();
	}
%>
	<form action="modifyOk.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<caption>정보수정</caption>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" value="<%=id %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>현비밀번호</th>
				<td><input type="password" name="oldPw" required="required"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="pw" placeholder="비밀번호 수정 원할시만 입력"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" value="<%=name %>" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<select name="phone1">
						<option></option> <!-- 목록에 빈칸 하나 넣기위함  -->
						<option <%if("010".equals(phone1)){
									out.print("selected='selected'");
									}%>>010</option>
						<option <%if("02".equals(phone1)){
									out.print("selected='selected'");
									}%>>02</option>
						<option <%if("031".equals(phone1)){
									out.print("selected='selected'");
									}%>>031</option>
						<option <%if("032".equals(phone1)){
									out.print("selected='selected'");
									}%>>032</option>
					</select> -
					<input type="text" name="phone2" value='<%=phone2!=null? phone2:"" %>' size=""> - 
					<input type="text" name="phone3" value='<%=phone3!=null? phone3:"" %>' size="">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%if("m".equals(gender)) {%><!-- 성별이 필수가 아니기에 세개로 나눠서 -->
						<input type="radio" name="gender" value="m" checked="checked">남
						<input type="radio" name="gender" value="f">여
					<%}else if("f".equals(gender)) {%>
						<input type="radio" name="gender" value="m">남
						<input type="radio" name="gender" value="f" checked="checked">여
					<%}else{ %>
						<input type="radio" name="gender" value="m">남
						<input type="radio" name="gender" value="f">여
					<%} %>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value='<%=email==null? "":email %>'></td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="tempbirth" value='<%=birth==null? "":birth.toString().substring(0,10)%>'></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" value='<%=address==null? "":address %>'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="정보수정">
					<input type="reset" value="취소" onclick="history.back()">
					<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>