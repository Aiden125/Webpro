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
	<%
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");	
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%-- <%=dto %> --%>
  
<%
	dto.setIp(request.getRemoteAddr()); //요청한 곳의 주소값 겟하기
	BoardDao dao = BoardDao.getInstance();
	int result;
	if(dto.getNum()==0){ //원글쓰기를 하려는거냐?
		result = dao.insertBoard(dto);
	}else{
		result = dao.reply(dto); //답변글 쓰기
	}
	if(result == BoardDao.SUCCESS){
%>
		<script>
			alert('글쓰기 완료');
			location.href = 'list.jsp?pageNum=<%=pageNum%>';
		</script>
		
<%	}else{%>
		<script>
			alert('글쓰기 실패');
			history.back();
		</script>
<%	}%>

</body>
</html>