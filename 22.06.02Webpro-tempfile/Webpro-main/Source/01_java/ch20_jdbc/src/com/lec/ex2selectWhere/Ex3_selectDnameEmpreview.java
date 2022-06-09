package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
1. 사용자에게 부서명을 받아
	1-1. 부서존재하는경우 : 부서명과 사원정보(사번, 이름, 급여, 급여등급)를 출력
	1-2. 부서존재하지 않는 경우 : 없다고 출력
*/
public class Ex3_selectDnameEmpreview {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("입력하실 부서명은?");
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
				System.out.println("입력하신 부서명이 존재하지 않습니다");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("1번오류"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("2번오류"+e.getMessage());
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
