<%@page import="com.lec.member.MemberDao"%>
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
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page"/> <!-- bean 파일을 쓰겠다 -->
	<jsp:setProperty name="dto" property="*"/> <!-- 모든 파라미터를 가져오겠다(생년월일은 따로 처리해줘야함) -->
<%
	// birth 처리해주기(현재는 Timestamp이며, Date형은 주석으로 달아놓음)
	String tempbirth = request.getParameter("tempbirth");
	if(!tempbirth.equals("")){
		dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00"));
		//dto.setBirth(Date.valueOf(tempbirth))
	}
	
	MemberDao mDao = MemberDao.getInstance();
	int result = mDao.confirmId(dto.getId()); // ID 중복체크
	
	if(result == MemberDao.MEMBER_NONEXISTENT){ //사용 가능한 경우
		result = mDao.joinMember(dto); //회원가입. (만약 회원가입DB오류면 result에 0)
		if(result == MemberDao.SUCCESS){ //회원가입 성공
			session.setAttribute("id", dto.getId()); //회원가입만해서 id세션만 증정%>
			<script>
			alert("회원가입 감사합니다.");
			location.href="login.jsp";
			</script>
		<%}else{ //회원가입 실패(DB오류)%>
			<script>
			alert("회원가입 실패.");
			history.back();
			</script>
		<%}
		
	}else{ //사용 불가(이미 존재)%>
		<script>
			alert("중복된 아이디.");
			location.href="login.jsp";
			history.back();
			</script>
	<%}
%>
	

	
</body>
</html>