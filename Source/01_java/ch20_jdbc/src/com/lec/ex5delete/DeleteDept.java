package com.lec.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// ����ڷκ��� �����ϰ��� �ϴ� �μ���ȣ�� �Է¹޾� �����ϱ�(+�����ͺ��̽����� 7�ܰ�)
public class DeleteDept {
	public static void main(String[] args) {
		
		// �����ǹ�?
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = null; // ���� �ǹ�??
		Statement stmt = null; // ���� �ǹ�??
		
		System.out.println("������ �μ���ȣ��?");
		int deptno = scanner.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		
		////// ���������� 1�ܰ� �ϱ� ���� �ϴ� �κ�.
		
		try {
			Class.forName(driver); // 1�ܰ� ����̹��ε�. ö�ڰ� Ʋ���� �������� ���Ҽ��� �����ϱ� ����ó���ؾ���
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2�ܰ� �����ͺ��̽� �����ϱ�(�α��ΰ��������ε�?)(�α��� ���Ҽ��� ������ ����ó��)
			stmt = conn.createStatement(); // 3�ܰ� SQL�� �������ִ� ��ü �����.(������ ���� stmt)
			int result = stmt.executeUpdate(sql); // 4,5�ܰ� sql���� �����ؼ� result�ȿ� ����� ������ �޴°� 1�̸� �μ� �ִ°�, 0�̸� �μ� ���°�
			// + execute���� ��Ȯ�� � ��������?
			
			System.out.println(result > 0? deptno+"�� ��������" : deptno+"�� �μ��� �����ϴ�"); //�ܼ��� ���׿��� �̿��� ����Ǵ��ؼ� �ǵ���ֱ�
			
			
		} catch (ClassNotFoundException e) { // 1�ܰ� ����̹��ε� �� ����ó���Ѱ�.
			System.out.println("����̹� �ε� ���� : "+e.getMessage());
		} catch (SQLException e) { // 2�ܰ� �����ͺ��̽� �����ϴ� �κ� ����ó��(���� �ȵ��� ���)
			System.out.println("SQL ���� : "+e.getMessage());
		} finally { // ����� �־ �ݾ�����ϱ� ������
			try { // 7�ܰ� ��ü��? ������? �ݾ��ֱ�
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
