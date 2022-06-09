package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
// EMP테이블의 모든 정보를 출력하기
// 사번, 이름, 직책, 상사사번, 입사일, 급여, 상여, 부서번호
public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 1521:오라클 포트번호, xe:오라클SID코드
		Connection conn = null; // DB연결객체 변수
		Statement stmt  = null; // SQL전송객체 변수
		ResultSet rs 	= null; // SELECT문 결과 받는 객체 변수
		String query = "SELECT * FROM EMP";
		
		try {
			Class.forName(driver); // 1단계 : 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2 단계 : DB연결
			stmt = conn.createStatement(); // 3단계 : SQL문 전송 객체생성
			rs = stmt.executeQuery(query); // 4단계 : SQL전송 + 5단계 : SQL전송 결과 받기
			// 6단계 : 결과 받아서 원하는 로직 수행
			System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
			
			while(rs.next()) {
				int empno = rs.getInt("empno"); // empno를 숫자형태로 가져와라
				String ename = rs.getString("empno"); // ename를 문자형태로 가져와라
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				// Date hiredate = rs.getDate("hiredate"); 세가지 방법
				// String hiredate = rs.getString("hiredate");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				if(job.length()<7) {
					System.out.printf("%d \t %s \t %s \t\t %d \t %TF \t %d \t %d \t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				} else {
					System.out.printf("%d \t %s \t %s \t %d \t %TF \t %d \t %d \t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
				}
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7단계 : 연결해제. 꼭 객체 만든 순서 반대로
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		} // try-catch-finally
	} // main
} // class

// select문 : 결과를 rs절에 받음. 결과가 여러줄
// insert, update, delete문 : 결과가 int 정수
  
