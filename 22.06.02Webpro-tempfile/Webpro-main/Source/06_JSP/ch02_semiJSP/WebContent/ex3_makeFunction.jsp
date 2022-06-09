<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%-- 지시자(<%@ ~~~~~ %>) : 페이지속성 --%>
<%-- 스크립트릿 (<% ~~~~ %>) : 자바코드 넣는 부분 --%>
<%-- 선언부(<%! ~~~~ %>) : 느낌표로 시작하는 부분(보통 변수, 함수를 넣는다) --%>

	<% //스크립트릿(자바코드 넣는부분)
		long result = power(2,3);
	%>
	<p>2의 3승은<%=result %>입니다</p>
	<p>9의 11승은 <%=power(9,11) %>입니다</p>
	
	<%! //선언부는 !을 붙여서 선언함 현재 이줄처럼
	private long power(int a, int b){// 선언부 : a의 b승을 return할 power함수 선언(아무데서나 호출가능)
		long temp = 1;
		for(int i=1; i<=b; i++){
			temp *= a;
		}
		return temp;
	}
	%>	
</body>
</html>