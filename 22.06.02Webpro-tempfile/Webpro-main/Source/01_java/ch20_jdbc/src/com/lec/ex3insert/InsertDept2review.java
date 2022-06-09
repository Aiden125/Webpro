package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 부서번호를 입력받아 중복체크 후 입력
public class InsertDept2review {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 중복체크 sql작성(count 함수 이용해서 selectSQL작성 count가 0이면 중복x)
		System.out.println("입력하실 부서번호는?");
		int deptno = sc.nextInt();
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt!=0) {
				System.out.println("이미 존재하는 부서입니다.");
			}else {
				System.out.println("입력하실 부서명은?");
				String dname = sc.next();
				System.out.println("입력하실 주소는?");
				sc.nextLine();
				String loc = sc.nextLine();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')",
						deptno, dname, loc);
				
				int result = stmt.executeUpdate(insertSQL);
				if(result > 0) {
					System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				}
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
