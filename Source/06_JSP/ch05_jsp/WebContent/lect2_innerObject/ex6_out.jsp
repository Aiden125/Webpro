<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" %>
<!DOCTYPE html>
									<!-- 요약정리  -->
					<!-- .jsp파일에서 스트립 트릿 안에서 out.println해서 프린트할수도,
					html영역에서 프린트할수도 있으나 out.print를 자주 쓰면 버퍼를 그만큼
					많이 잡아먹기 때문에 효율성 문제로 길이가 길어지면 html부분에 쓰는게 불문율-->
					
					<!-- out.print는 소스보기 했을 때 한줄로,
						out.println은 소스보기 했을 때 여러줄로 뜸 큰 차이x -->
					
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>버퍼의 크기 : <%=out.getBufferSize() %></h2>
	<h2>버퍼의 남은 크기 : <%=out.getRemaining() %></h2>
	<%
	for(int i=0; i<1000; i++){
		out.print("<h2>테스트함 : i = " + i + "번째에서 남은 버퍼 크기 : "+out.getRemaining()+"<br>");
	}
	%>
</body>
</html>