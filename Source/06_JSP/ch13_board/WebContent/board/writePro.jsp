<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- useBean을 써서 쓴건 다 넘어오고 안쓴건 null값으로 들어옴 -->
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%-- <%=dto %> --%>
<%
	dto.setIp(request.getRemoteAddr()); //요청한 곳의 주소값 겟하기
	BoardDao dao = BoardDao.getInstance();
	int result = dao.insertBoard(dto);
	if(result == BoardDao.SUCCESS){		
		out.println("<script>");
		out.println("alert('글쓰기 완료')");
		out.println("location.href='list.jsp'");
		out.println("</script>");
	}else{
		out.println("<script>");
		out.println("alert('글쓰기 실패')");
		out.println("history.back()");
		out.println("</script>");
	}
%>	
</body>
</html>