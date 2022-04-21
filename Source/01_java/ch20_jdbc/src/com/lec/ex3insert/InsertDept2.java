package com.lec.ex3insert;
// 부서번호를 입력받아 중복체크 확인 후 입력 진행
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null; // DB연결객체 변수
		Statement stmt = null; // SQL전송객체 변수
		ResultSet rs = null; // SELECT문 결과 받는 객체 변수		

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			System.out.println("입력할 부서번호는?");
			int deptno = scanner.nextInt();
			// 부서번호 중복체크
			String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
			
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt!=0) {
				System.out.println("중복된 부서입니다.");
			}else {
				System.out.println("입력할 부서이름은?");
				String dname = scanner.next();
				System.out.println("입력할 부서위치는?");
				scanner.nextLine();
				String loc = scanner.nextLine();
				String insertSql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSql);
				if(result>0) {
					System.out.println("입력 성공");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try { // (7)
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		}
	}
}

// System.out.println("입력할 부서이름은?");
// String dname = scanner.next();
// System.out.println("입력할 부서위치는?");
// String loc = scanner.next();
// String sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')", deptno, dname, loc);
// insert를 날리려고 하기 때문에 resultset 필요없음(resultset은 셀렉트 할 때)
