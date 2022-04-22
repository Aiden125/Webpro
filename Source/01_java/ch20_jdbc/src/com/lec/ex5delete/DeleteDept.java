package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자로부터 삭제하고자 하는 부서번호를 입력받아 삭제하기(+데이터베이스연동 7단계)
public class DeleteDept {
	public static void main(String[] args) {
		
		// 무슨의미?
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = null; // 무슨 의미??
		Statement stmt = null; // 무슨 의미??
		
		System.out.println("삭제할 부서번호는?");
		int deptno = scanner.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		
		////// 위에까지가 1단계 하기 전에 하는 부분.
		
		try {
			Class.forName(driver); // 1단계 드라이버로드. 철자가 틀려서 파일접근 못할수도 있으니까 예외처리해야함
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2단계 데이터베이스 접속하기(로그인같은개념인듯?)(로그인 못할수도 있으니 예외처리)
			stmt = conn.createStatement(); // 3단계 SQL문 전송해주는 객체 만들기.(전달자 역할 stmt)
			int result = stmt.executeUpdate(sql); // 4,5단계 sql문을 전송해서 result안에 결과값 정수로 받는거 1이면 부서 있는거, 0이면 부서 없는거
			// + execute문이 정확히 어떤 문장인지?
			
			System.out.println(result > 0? deptno+"번 삭제성공" : deptno+"번 부서는 없습니다"); //단순히 삼항연산 이용해 결과판단해서 피드백주기
			
			
		} catch (ClassNotFoundException e) { // 1단계 드라이버로드 때 예외처리한거.
			System.out.println("드라이버 로드 오류 : "+e.getMessage());
		} catch (SQLException e) { // 2단계 데이터베이스 접속하는 부분 예외처리(접속 안됐을 경우)
			System.out.println("SQL 오류 : "+e.getMessage());
		} finally { // 어떤일이 있어도 닫아줘야하기 때문에
			try { // 7단계 객체들? 변수들? 닫아주기
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
