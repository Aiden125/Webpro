package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// preparedStatement�� �Ἥ insert �ޱ�. �μ�Ʈ�� ���� ,�ܼ��� stmt���°ź��� ����
public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		//�߰��� ������ �ޱ�
		System.out.println("�߰��� �μ���ȣ?");
		int deptno = scanner.nextInt();
		System.out.println("�߰��� �μ��̸�?");
		String dname = scanner.next();
		System.out.println("�߰��� �μ� ��ġ?");
		String loc = scanner.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//prepared �� ���� ����(��ĳ��) �ޱ����� sql�� �ᵵ �� ���x. (����ǥ�� ó���Ұű� ������)
		//�Ʒ� ������ ��ȯ�ϴ� ��
		//String sql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+"' WHERE DEPTNO="+deptno;
		String sql = "INSERT INTO DEPT VALUES(?, ?, ?)";
		
		//��������� 1�ܰ�����ϱ� ���� �ؾߵɰ͵�
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); //prepared������ sql�־������ SQL���۰�ü ??���� �����ϴ°�(�ڹٷ� �����ϴ°� �³�?)
			//stmt = createstatement(); �������� �̷������� �����
			
			pstmt.setInt(1,  deptno); // sql�� ù��° ����ǥ�� ��Ʈ������ deptno�� �����ϰڴ�.
			pstmt.setString(2,  dname); // �ι�° ����ǥ String������ dname���� �����ϰڴ�. String�̸� �˾Ƽ� �̱�Ŀ���̼� �ο�����
			pstmt.setString(3,  loc); // ����° ����ǥ String������ loc���� �����ϰڴ�. String�̸� �˾Ƽ� �̱�Ŀ���̼� �ο�����
			int result = pstmt.executeUpdate(); // sql�̶��� �ٸ� ��ȣ ����ֱ�.
			//in result = stmt.executeUpdate(sql);
			
			System.out.println(result > 0? deptno+"�� �Է¼���":"�Է� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
