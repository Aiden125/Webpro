package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_select {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("���ϴ� �μ�����?");
		String dname = scanner.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dname);
			
			rs = pstmt.executeQuery();
			//������ �κ�
//			if(rs.next()) { // �ش�μ��� ����� �ִ� ���
//				do {
//					int empno = rs.getInt("empno");
//					String ename = rs.getString("ename");
//					int sal = rs.getInt("sal");
//					int grade = rs.getInt("grade");
//					System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"���");
//				}while(rs.next());
//	
//			}else { // �ش� �μ����� ����� �ִ°��
//				System.out.println(dname +"�μ����� ����� �����ϴ�");
//			}
//		}else { 
//			System.out.println(dname+"�� ���� �μ��̸��Դϴ�.");
//		}
			if(rs.next()) {
				System.out.println(dname+"�μ��� ��������Դϴ�.");
				do {
					System.out.println("��� : "+rs.getInt("empno"));
					System.out.println("�̸� : "+rs.getString("ename"));
					System.out.println("��å : "+rs.getString("job"));
					System.out.println("�޿� : "+rs.getInt("sal")+"\n");
					} while(rs.next());
				}else {
					System.out.println("�ش�μ��� �������� �ʽ��ϴ�.");
			}
				
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
	}
}
