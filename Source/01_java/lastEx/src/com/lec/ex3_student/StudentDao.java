package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	public static int SUCCESS=1;
	public static int FAIL=0;
	
	private static StudentDao INSTANCE=null;
	public static StudentDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	
	
	public StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// 1���Է� - �й��˻�
	// public StudentDto sNogetStudent(String sNo)
	public StudentDto selectSno(String sno) {
		StudentDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE "
				+ "FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SNO=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto = new StudentDto(sno,sname,mname,score);
				
			} 
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
		return dto;
	}
	
	// 2���Է� - �̸��˻�
	public ArrayList<StudentDto> selectSname(String sname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SNO, SNAME, MNAME, SCORE "
				+ "FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SNAME=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String sno = rs.getString("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(sno,sname,mname,score));
				
			} 
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
		return dtos;
	}
	// 3���Է� - �����˻�
	// 2���Է� - �̸��˻�
		public ArrayList<StudentDto> selectJname(String jname) {
			ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT SNO, SNAME, MNAME, SCORE "
					+ "FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SNAME=?";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, jname);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String sno = rs.getString("sno");
					String mname = rs.getString("mname");
					int score = rs.getInt("score");
					dtos.add(new StudentDto(sno,sname,mname,score));
					
				} 
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
			return dtos;
		}
	// 4���Է� - �л������Է�
	// 5���Է� - �л���������
	// 6���Է� - �л��������
	// 7���Է� - �������������
	// 8���Է� - ����ó��
}
