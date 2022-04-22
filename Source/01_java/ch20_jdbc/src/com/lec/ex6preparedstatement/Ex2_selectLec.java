package com.lec.ex6preparedstatement;
import java.sql.*;
import java.util.Scanner;
// 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
public class Ex2_selectLec {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		// (1)단계 ~ (7)단계
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.print("검색하고자 하는 부서명은?");
			pstmt.setString(1, scanner.next());
			rs = pstmt.executeQuery();
			if(rs.next()) { // 해당부서 사원이 있는 경우 list 출력
				System.out.println("사번\t이름\t직책\t\t급여");
				do {
					////////////// ???변수에 받아야되는 이유??? ////////
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job   = rs.getString("job");
					int sal   = rs.getInt("sal");
					if(job!=null && job.length()<=7) {
						System.out.println(empno+"\t"+ename+"\t"+job+"\t\t"+sal);
					}else {
						System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
					}
					////////////// ???변수에 받아야되는 이유??? ////////
				}while(rs.next());
			}else {
				System.out.println("해당 부서의 직원은 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}// close문의 try-catch
		}// DB 접속 try-catch
	}
}