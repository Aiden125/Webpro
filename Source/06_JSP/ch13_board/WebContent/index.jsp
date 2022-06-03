
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
	<jsp:forward page="board/list.jsp"/> <!-- 오직 forward만이 url이 안바뀜 -->
	<%-- <script>
		location.href='<%=conPath%>/board/list.jsp'
	</script> --%>
</body>
</html>