package com.lec.ex6preparedstatement;
import java.sql.*;
import java.util.Scanner;
// ����ڷκ��� �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
public class Ex2_selectLec {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner scanner = new Scanner(System.in);
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		
		// (1)�ܰ� ~ (7)�ܰ�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.print("�˻��ϰ��� �ϴ� �μ�����?");
			pstmt.setString(1, scanner.next());
			rs = pstmt.executeQuery();
			if(rs.next()) { // �ش�μ� ����� �ִ� ��� list ���
				System.out.println("���\t�̸�\t��å\t\t�޿�");
				do {
					////////////// ???������ �޾ƾߵǴ� ����??? ////////
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job   = rs.getString("job");
					int sal   = rs.getInt("sal");
					if(job!=null && job.length()<=7) {
						System.out.println(empno+"\t"+ename+"\t"+job+"\t\t"+sal);
					}else {
						System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
					}
					////////////// ???������ �޾ƾߵǴ� ����??? ////////
				}while(rs.next());
			}else {
				System.out.println("�ش� �μ��� ������ �����ϴ�");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}// close���� try-catch
		}// DB ���� try-catch
	}
}