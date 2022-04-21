package com.lec.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 1521:����Ŭ ��Ʈ��ȣ, xe:����ŬSID�ڵ�
		Connection conn = null;
		try {
			// 1. ����̹� �ε�
			Class.forName(driver);
			// 2. DB�� ���� ��ü ����
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB ���� ���� : " + e.getMessage());
			e.printStackTrace();
		} finally {
			// ���� ��ü ����
			if (conn != null)
				try {
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
