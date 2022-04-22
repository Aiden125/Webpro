package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
public class Ex2_select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("원하는 부서명은?");
		String dname = scanner.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dname);
			
			rs = pstmt.executeQuery();
			//참고한 부분
//			if(rs.next()) { // 해당부서명에 사원이 있는 경우
//				do {
//					int empno = rs.getInt("empno");
//					String ename = rs.getString("ename");
//					int sal = rs.getInt("sal");
//					int grade = rs.getInt("grade");
//					System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"등급");
//				}while(rs.next());
//	
//			}else { // 해당 부서명의 사원이 있는경우
//				System.out.println(dname +"부서에는 사원이 없습니다");
//			}
//		}else { 
//			System.out.println(dname+"은 없는 부서이름입니다.");
//		}
			if(rs.next()) {
				System.out.println(dname+"부서의 사원정보입니다.");
				do {
					System.out.println("사번 : "+rs.getInt("empno"));
					System.out.println("이름 : "+rs.getString("ename"));
					System.out.println("직책 : "+rs.getString("job"));
					System.out.println("급여 : "+rs.getInt("sal")+"\n");
					} while(rs.next());
				}else {
					System.out.println("해당부서는 존재하지 않습니다.");
			}
				
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
