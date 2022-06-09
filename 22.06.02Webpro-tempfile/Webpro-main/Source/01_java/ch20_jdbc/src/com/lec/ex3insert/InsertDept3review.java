package com.lec.ex3insert;
//�μ���ȣ�� �Է¹޾� �ߺ�üũ �� �Է�. ��, �ߺ� ��ȣ �Է½� �ٽ� �μ���ȣ �ǹ����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3review {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			while(true) {
				System.out.println("�Է��Ͻ� �μ���ȣ��?");
				int deptno = sc.nextInt();
				String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
				rs = stmt.executeQuery(selectSQL);
	
				rs.next();
				int cnt = rs.getInt("cnt");
				if(cnt!=0) {
					System.out.println("�̹� �����ϴ� �μ��Դϴ�.");
					continue;
					
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
						break;
					}else {
						System.out.println("�Է½���");
						continue;
					}
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
			
		}sc.close();
	}
}
