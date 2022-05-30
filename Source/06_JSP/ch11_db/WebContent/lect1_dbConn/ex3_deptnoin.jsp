<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	<form action="ex3_deptnoOut.jsp">
		부서번호
		<select name="deptno">
			<option value="0"></option>
			<%
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM DEPT";
				try{
					//드라이버 연결
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					// 보여주기 형태는 10 - sales 이런식, 값 넘기는건 10 이렇게 숫자만 하려면 아래처럼
					// <option value='10'>10 - sales</option>
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					out.println("<option value='"+deptno+"'>"+deptno+" - "+dname+"</option>");
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}
				
			%>
		</select>
	</form>
</body>
</html>