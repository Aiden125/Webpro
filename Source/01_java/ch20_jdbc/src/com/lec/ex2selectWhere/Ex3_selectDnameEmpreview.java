package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
1. ����ڿ��� �μ����� �޾�
	1-1. �μ������ϴ°�� : �μ���� �������(���, �̸�, �޿�, �޿����)�� ���
	1-2. �μ��������� �ʴ� ��� : ���ٰ� ���
*/
public class Ex3_selectDnameEmpreview {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("�Է��Ͻ� �μ�����?");
		String dname = sc.next();
		String sql = String.format("SELECT DNAME, EMPNO, ENAME, SAL, GRADE " + 
				"    FROM EMP E, DEPT D, SALGRADE " + 
				"    WHERE E.DEPTNO=D.DEPTNO " + 
				"    AND SAL BETWEEN LOSAL AND HISAL " + 
				"    AND DNAME=UPPER('%s') ", dname);
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					dname = rs.getString("dname");
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					int sal = rs.getInt("sal");
					int grade = rs.getInt("grade");
					System.out.printf("%s \t %d \t %s \t %d \t %d\n", dname, empno, ename, sal, grade);
				}while(rs.next());
					
			} else {
				System.out.println("�Է��Ͻ� �μ����� �������� �ʽ��ϴ�");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("1������"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("2������"+e.getMessage());
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
