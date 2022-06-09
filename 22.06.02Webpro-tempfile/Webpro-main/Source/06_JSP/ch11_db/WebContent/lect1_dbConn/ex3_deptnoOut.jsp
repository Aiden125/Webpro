<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	//드라이버 연결
	String driver   = "oracle.jdbc.driver.OracleDriver";
	String url		= "jdbc:oracle:thin:@localhost:1521:xe";
	
	//아이디 비번 연결
	String uid		= "scott";
	String upw		= "tiger";
	
	//변수선언
	Connection conn	= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM EMP WHERE DEPTNO=?";
	
	//아래 두 줄은 이 파일부터 실행되는 경우에 대한 예외방지(500에러 날 수 있기에)
	String deptnoStr = request.getParameter("deptno");
	if(deptnoStr==null)
		deptnoStr = "0";
	int deptno = Integer.parseInt(deptnoStr);
	
	//try-catch
	try{
		Class.forName(driver); // 1단계
		conn = DriverManager.getConnection(url, uid, upw); // 2단계
		pstmt = conn.prepareStatement(sql); // 3단계
		pstmt.setInt(1, deptno);
		rs = pstmt.executeQuery(); // 4단계 + 5단계
		out.println("<table>");
		if(rs.next()){ //이게 트루면 사원이 있는거
			out.println("<tr><th>사번</th><th>이름</th><th>입사일</th><th>부서번호</th></tr>");
			do{
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+hiredate+"</td><td>"+deptno+"</td></tr>");
			}while(rs.next());
		}else{ //여기면 사원이 없는거
			out.println("<tr><td>사원이 없습니다</td></tr>");	
		}
		out.println("</table>");
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
	<button onclick="location.href='ex3_deptnoin.html'">다시 검색</button>
</body>
</html>