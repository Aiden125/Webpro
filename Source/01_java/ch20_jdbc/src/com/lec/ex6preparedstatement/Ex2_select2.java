package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 스스로 응용. 존재하는 부서명들을 보여준 뒤,
// 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
public class Ex2_select2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;

		String sqlinfo = "SELECT DNAME FROM DEPT";
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt2 = conn.prepareStatement(sqlinfo);
			rs2 = pstmt2.executeQuery();
			System.out.println("현재 존재하는 부서명 정보입니다.");
			if (rs2.next()) {
				do {
					System.out.print("["+rs2.getString("dname")+"]"+"  ");
				} while (rs2.next());
			} else {
			}
			System.out.println("\n원하는 부서명은?");
			String dname = scanner.next();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);

			rs = pstmt.executeQuery();
			//
			if (rs.next()) {
				System.out.println(dname + "부서의 사원정보입니다.");
				do {
					System.out.println("사번 : " + rs.getInt("empno"));
					System.out.println("이름 : " + rs.getString("ename"));
					System.out.println("직책 : " + rs.getString("job"));
					System.out.println("급여 : " + rs.getInt("sal") + "\n");
				} while (rs.next());
			} else {
				System.out.println("해당부서는 존재하지 않습니다.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("1번오류");
		} catch (SQLException e) {
			System.out.println("2번오류");
		} finally {
			try {

				if (rs2 != null)
					rs2.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
