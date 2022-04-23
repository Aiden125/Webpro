package com.lec.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// �μ���ȣ�� �Է¹޾� �ߺ�üũ �� �Է�
public class InsertDept2review {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// �ߺ�üũ sql�ۼ�(count �Լ� �̿��ؼ� selectSQL�ۼ� count�� 0�̸� �ߺ�x)
		System.out.println("�Է��Ͻ� �μ���ȣ��?");
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
				System.out.println("�̹� �����ϴ� �μ��Դϴ�.");
			}else {
				System.out.println("�Է��Ͻ� �μ�����?");
				String dname = sc.next();
				System.out.println("�Է��Ͻ� �ּҴ�?");
				sc.nextLine();
				String loc = sc.nextLine();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')",
						deptno, dname, loc);
				
				int result = stmt.executeUpdate(insertSQL);
				if(result > 0) {
					System.out.println("�Է¼���");
				}else {
					System.out.println("�Է½���");
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
