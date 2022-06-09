<!-- 쿠키 리스트 출력하기  -->
<!-- id, name 쿠키를 출력할건데, 시스템도 쿠키를 만들기 때문에 outOk라는 boolean변수를 스위치로
만들어 놓고 id, name 쿠키가 있으면 그거를 출력하고 아니면 출력 안하도록-->

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
<%boolean outOk = false;
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			String cname = c.getName();
			String cvalue = c.getValue();
			if(cname.equals("id") || cname.equals("name")){
				out.println(cname + "(쿠키이름) / " + cvalue + "(쿠키값)<");
				outOk = true;
			}
		}
	}
	if(!outOk) {
		out.println("<h3>생성된 쿠키가 없습니다(시스템 쿠키 제외)</h3>");
	}
%>
	<button onclick="history.back()">이전페이지</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지</button>
</body>
</html>