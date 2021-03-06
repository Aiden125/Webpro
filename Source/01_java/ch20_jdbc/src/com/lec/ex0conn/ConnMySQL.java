package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/MOONDB?serverTimezone=UTC";
		Connection conn = null;
		try {
			Class.forName(driver); // 1. 드라이버로드
			conn = DriverManager.getConnection(url, "root" , "mysql"); // 2. DB 연결 객체 생성
			System.out.println("MYSQL DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		} // try-catch-finally
	} //main
} //class
