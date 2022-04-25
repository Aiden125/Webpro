package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 1521:오라클 포트번호, xe:오라클SID코드
		Connection conn = null;
		try {
			// 1. 드라이버 로드
			Class.forName(driver);
			// 2. DB와 연결 객체 생성
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			// 연결 객체 해제
			if (conn != null)
				try {
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
