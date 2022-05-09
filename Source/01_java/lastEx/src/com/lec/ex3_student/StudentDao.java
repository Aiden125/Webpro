package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

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
	
	//0.첫화면에 전공이름들 콤보박스에 추가(mname)
	public Vector<String> getMnamelist(){
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			}
		}
		return mnames;
	}
	
	// 1번입력 - 학번검색
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
				dto = new StudentDto(mname,sname,score,sno);
				
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
	
	// 2번입력 - 이름검색
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
				dtos.add(new StudentDto(mname,sname,score,sno));
				
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
	
	// 3번입력 - 전공검색
		public ArrayList<StudentDto> selectMname(String mname) {
			ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String msql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE" + 
					"    FROM (SELECT SNAME||'('||SNO||')' SNAME, MNAME||'('||S.MNO||')' MNAME, SCORE " + 
					"    FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND MNAME=? ORDER BY SCORE DESC) A ";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(msql);
				pstmt.setString(1, mname);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int rank = rs.getInt("rank");
					String sname = rs.getString("sname");
					int score = rs.getInt("score");
					dtos.add(new StudentDto(rank,sname,mname,score));
					
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
		
	// 4번입력 - 학생정보입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO, MNO, SNAME, SCORE)" + 
				"    VALUES(TO_CHAR(SYSDATE, 'YYYY')||LPAD(STUDENT_SQ.NEXTVAL, 3, 0), (SELECT MNO FROM MAJOR WHERE MNAME=?), ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getSname());
			pstmt.setInt(3, dto.getScore());
			result = pstmt.executeUpdate();
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

		return result;
	}

			
	// 5번입력 - 학생정보수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE STUDENT SET "
				+ "MNO=(SELECT MNO FROM MAJOR WHERE MNAME=?), SNAME=?, SCORE=? WHERE SNO=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getSname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getSno());
			result = pstmt.executeUpdate();
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
		return result;
	}


	// 6번입력 - 학생정보출력
	public ArrayList<StudentDto> selectAll(){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>(); // 변수 리턴하기 위해 정의
		// 직업별 조회 결과를 dtos에 add (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE "+ 
				"    FROM (SELECT SNAME||'('||SNO||')' \"SNAME\", MNAME||'('||S.MNO||')' \"MNAME\", SCORE " + 
				"    FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO ORDER BY SCORE DESC) A";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setRank(rs.getInt("rank"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
				
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
	
	// 7번입력 - 제적자정보출력
	public ArrayList<StudentDto> selectSexpel(){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>(); // 변수 리턴하기 위해 정의
		// 직업별 조회 결과를 dtos에 add (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE " + 
				"    FROM (SELECT SNAME||'('||SNO||')' \"SNAME\", MNAME||'('||S.MNO||')' \"MNAME\", SCORE " + 
				"    FROM STUDENT S, MAJOR M WHERE S.MNO=M.MNO AND SEXPEL=1 ORDER BY SCORE DESC) A";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setRank(rs.getInt("rank"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dtos.add(dto);
				
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
	
	// 8번입력 - 제적처리
	public int updateSexpel(StudentDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE STUDENT SET SEXPEL=1 WHERE SNO=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSno());
			result = pstmt.executeUpdate();
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
		return result;
	}
}

