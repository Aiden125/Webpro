package com.lec.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/MOONDB?serverTimezone=UTC";
		String sql = "SELECT * FROM PERSONAL";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver); // 1�ܰ� : ����̹� �ε�
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2�ܰ�
			stmt = conn.createStatement(); // 3�ܰ�
			rs = stmt.executeQuery(sql); // 4�ܰ� + 5�ܰ�
			if(rs.next()) { // SELECT ����� �ִ� ���
				System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t��\t�μ���ȣ");
				do{
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					System.out.println
					(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
					
				}while(rs.next());
			}else { // SELECT�� ����� �� �൵ ���� ���
				System.out.println("PERSONAL �����Ͱ� �����ϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7�ܰ� : ��������. �� ��ü ���� ���� �ݴ��
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		} // try-catch-finally
	}
}