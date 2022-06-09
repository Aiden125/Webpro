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
			Class.forName(driver); // 1단계 : 드라이버 로드
			conn = DriverManager.getConnection(url, "root", "mysql"); // 2단계
			stmt = conn.createStatement(); // 3단계
			rs = stmt.executeQuery(sql); // 4단계 + 5단계
			if(rs.next()) { // SELECT 결과가 있는 경우
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t\t급여\t상여\t부서번호");
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
			}else { // SELECT문 결과가 한 행도 없는 경우
				System.out.println("PERSONAL 데이터가 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { // 7단계 : 연결해제. 꼭 객체 만든 순서 반대로
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { }
		} // try-catch-finally
	}
}
