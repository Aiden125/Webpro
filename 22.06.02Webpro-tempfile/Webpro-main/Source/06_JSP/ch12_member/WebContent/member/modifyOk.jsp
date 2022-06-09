<%@page import="com.lec.member.MemberDao"%>
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

</head>
<body>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		request.setCharacterEncoding("utf-8");
		//birth 처리 해주기
		String tempbirth = request.getParameter("tempbirth");
		if(!tempbirth.equals("")){
			dto.setBirth(Timestamp.valueOf(tempbirth + " 00:00:00")); //00 앞에 스페이스 꼭 띄워야 한다.
		}
		MemberDto member = (MemberDto)session.getAttribute("member");
		String sessionPw = null;
		if(member!=null){ //로그인 되어있을 때
			sessionPw = member.getPw(); //세션의 pw를 sessionPw에 할당
		}
		String oldPw = request.getParameter("oldPw");
		if(sessionPw.equals(oldPw)){ //수정창에서 현재 비밀번호를 맞게 입력한 경우
			// 새비밀번호가(newPw파라미터) null로 입력되지 않을 경우 현재 비밀번호로 수정
			if(dto.getPw()==null){
				dto.setPw(sessionPw);
			}
			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.modifyMember(dto);
			if(result==MemberDao.SUCCESS){ //수정 성공 
				session.setAttribute("member", dto); //수정된 DB내용을 session속성으로 부여
				out.println("<script>");
				out.println("alert('회원정보 수정이 완료되었습니다.')");
				out.println("location.href='main.jsp'");			
				out.println("</script>");
			}else { //수정 실패
				out.println("<script>");
				out.println("alert('회원정보 수정이 실패했습니다. 정보가 너무 깁니다')");
				out.println("history.back()");			
				out.println("</script>");
			}
		}else{ //수정창에서 현재 비밀번호를 틀린 경우
			out.println("<script>");
			out.println("alert('현 비밀번호가 틀립니다.'))");
			out.println("history.back()");			
			out.println("</script>");
		}
	%>
</body>
</html>