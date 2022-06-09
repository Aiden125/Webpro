package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

// EMP테이블의 모든 정보를 출력하기
// 사번, 이름, 직책, 상사사번, 입사일, 급여, 상여, 부서번호
// 이쁘게 출력은 안한버전

public class selectAllOraclereview {
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 1521:오라클 포트번호, xe:오라클SID코드
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP";
		
		
		try {
			Class.forName(driver); //1단계 - 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); //2단계 접속
			stmt = conn.createStatement(); //3단계 sql객체 생성
			rs = stmt.executeQuery(sql); //4, 5단계 sql문 쏴주기 및 변수받기
			
			//6단계 원하는 로직 수행
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
			System.out.printf("%d \t %s \t %s \t %d \t %TF \t %d \t %d \t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
