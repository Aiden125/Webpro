<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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
	String name = request.getParameter("name");
	if(name==null) name = "-1";
	String driver   = "oracle.jdbc.driver.OracleDriver";
	String url		= "jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
%>
	<form action="">
		<table>
			<tr>
				<td colspan="4">
				이름
				<input type="text" name="name" value="<%if(name!="-1"){
					String upperName = name.toUpperCase(); 
					out.println(upperName);}%>">
				<input type="submit" name="search" value="검색">
				</td>
			</tr>
				<!-- DB에서 조회된 부분 출력 공간 -->
				<%  if(name!="-1"){ 
					String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%'||upper(?)||'%'";
					try{
						Class.forName(driver);
						conn = DriverManager.getConnection(url, "scott", "tiger");
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, name);
						rs = pstmt.executeQuery();
						if(rs.next()){
							out.println("<tr><th>이름</th><th>입사일</th><th>급여</th><th>부서번호</th></tr>");
							do{
								String ename = rs.getString("ename");
								Date hiredate = rs.getDate("hiredate");
								int sal = rs.getInt("sal");
								int deptno = rs.getInt("deptno");
								out.println("<tr><td>"+ename+"</td><td>"+hiredate+"</td><td>"+sal+
															"</td><td>"+deptno + "</td></tr>");
							}while(rs.next());
						}else{
							out.println("<tr><td>해당이름을 가진 사원이 존재하지 않습니다.</tr></td>");
							/* out.println("<script>");
							out.println("alert('해당 이름 사원이 없습니다')");
							out.println("history.back()");
							out.println("</script>"); */
						}
					}catch(Exception e){
						System.out.println(e.getMessage());
					}finally{
						// close되면 모두 null로 돌아감
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					}
				}
				%>
		</table>
	</form>
</body>
</html>