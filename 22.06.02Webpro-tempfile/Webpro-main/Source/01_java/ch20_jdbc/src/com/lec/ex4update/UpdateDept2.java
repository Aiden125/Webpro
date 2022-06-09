package com.lec.ex4update;
// �����ϰ��� �ϴ� �μ���ȣ �Է� -> �����ϴ� �μ���ȣ���� üũ -> �μ���� ��ġ�� �޾� ����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UpdateDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver); // 1
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2
			stmt = conn.createStatement(); // 3
			
			System.out.println("������ �μ���ȣ?");
			int deptno = sc.nextInt();
			// �ش� �μ��� �ִ��� üũ
			String selectSQL = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt!=0) {
				System.out.println("�����ϴ� �μ��Դϴ�. ��� ����˴ϴ�.");
				System.out.println("������ �μ���?");
				String dname = sc.next();
				System.out.println("������ ��ġ��?");
				String loc = sc.next();
				String sql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+"' WHERE DEPTNO="+deptno;
				int result = stmt.executeUpdate(sql);
				System.out.println(result>0? "��������" : "�ش� �μ��� �������");
			}else {
				System.out.println("�ش� �μ��� �������� �ʽ��ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		}
	}
}
