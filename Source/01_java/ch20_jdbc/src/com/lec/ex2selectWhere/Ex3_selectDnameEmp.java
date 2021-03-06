package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
1. 사용자에게 부서명을 받아
	1-1. 부서존재하는경우 : 부서정보와 사원정보(사원, 이름, 급여, 급여등급)를 출력
	1-2. 부서존재하지 않는 경우 : 없다고 출력
*/
// 결과값 도출 성공. 이쁘게 정리한건 아니기 떄문에 출력이 이쁘게 되진 않는 상태
// 틀렸던 부분 - String.format으로 변수 넣을 때 %s 로 입력값을 넣는데 ''(싱글커테이션) 안넣어서 오류 발생했었음(주의)
public class Ex3_selectDnameEmp {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select문 전송을 위한 구문
		Scanner scanner = new Scanner(System.in);
		System.out.println("원하는 부서명은 ?");
		String dname = scanner.next();
		// String sql1 = "SELECT * FROM DEPT WHERE DNAME=UPPER('"+dname+"')";
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME=UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
					" FROM EMP E, SALGRADE, DEPT D" + 
					" WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO" + 
					" AND DNAME=UPPER('%s')", dname);
		
		try {
			Class.forName(driver); // (1)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(sql1); // (4) + (5)
			
			if(rs.next()) {
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서 이름 : "+dname);
				System.out.println("부서 위치 : "+rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(sql2); // (4) + (5)
				
				if(rs.next()) { // 해당부서명에 사원이 있는 경우
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int grade = rs.getInt("grade");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+grade+"등급");
					}while(rs.next());
		
				}else { // 해당 부서명의 사원이 있는경우
					System.out.println(dname +"부서에는 사원이 없습니다");
				}
			}else { 
				System.out.println(dname+"은 없는 부서이름입니다.");
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
			} catch (SQLException e) { }
		}
		
	}
}
