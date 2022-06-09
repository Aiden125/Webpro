package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// ������ ����. �����ϴ� �μ������ ������ ��,
// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_select2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;

		String sqlinfo = "SELECT DNAME FROM DEPT";
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + "    FROM EMP E, DEPT D"
				+ "    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt2 = conn.prepareStatement(sqlinfo);
			rs2 = pstmt2.executeQuery();
			System.out.println("���� �����ϴ� �μ��� �����Դϴ�.");
			if (rs2.next()) {
				do {
					System.out.print("["+rs2.getString("dname")+"]"+"  ");
				} while (rs2.next());
			} else {
			}
			System.out.println("\n���ϴ� �μ�����?");
			String dname = scanner.next();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);

			rs = pstmt.executeQuery();
			//
			if (rs.next()) {
				System.out.println(dname + "�μ��� ��������Դϴ�.");
				do {
					System.out.println("��� : " + rs.getInt("empno"));
					System.out.println("�̸� : " + rs.getString("ename"));
					System.out.println("��å : " + rs.getString("job"));
					System.out.println("�޿� : " + rs.getInt("sal") + "\n");
				} while (rs.next());
			} else {
				System.out.println("�ش�μ��� �������� �ʽ��ϴ�.");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("1������");
		} catch (SQLException e) {
			System.out.println("2������");
		} finally {
			try {

				if (rs2 != null)
					rs2.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
