package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

// EMP���̺��� ��� ������ ����ϱ�
// ���, �̸�, ��å, �����, �Ի���, �޿�, ��, �μ���ȣ
// �̻ڰ� ����� ���ѹ���

public class selectAllOraclereview {
	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 1521:����Ŭ ��Ʈ��ȣ, xe:����ŬSID�ڵ�
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP";
		
		
		try {
			Class.forName(driver); //1�ܰ� - ����̹� �ε�
			conn = DriverManager.getConnection(url, "scott", "tiger"); //2�ܰ� ����
			stmt = conn.createStatement(); //3�ܰ� sql��ü ����
			rs = stmt.executeQuery(sql); //4, 5�ܰ� sql�� ���ֱ� �� �����ޱ�
			
			//6�ܰ� ���ϴ� ���� ����
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
			System.out.printf("%d \t %s \t %s \t %d \t %TF \t %d \t %d \t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
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
