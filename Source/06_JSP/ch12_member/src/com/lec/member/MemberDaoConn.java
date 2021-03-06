package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoConn {
	public static final int SUCCESS = 1; // 회원가입, 정보수정 시 성공 리턴값
	public static final int FAIL = 0; // 회원가입, 정보수정 시 실패 리턴값
	public static final int MEMBER_EXISTENT = 0; // 중복된 ID일 때 리턴값 
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 ID일 때 리턴값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공 시
	public static final int LOGIN_FAIL_ID = -1; // ID오류로 로그인 실패시
	public static final int LOGIN_FAIL_PW = 0; // PW오류로 로그인 실패시
	
	
	// conn 객체 리턴하는 함수 - 필요할때 간단하게 메소드만 호출하려고
	// conn함수 정의 및 throws 해주기(exception 두개 throws 되는데 Exception 하나로 바꿔주기)
	private Connection getConnection() throws SQLException{
		//커넥션풀의 DataSource안의 conn객체 이용
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("커넥션풀이름 오류 : "+e.getMessage());
		}
		return conn;
	}
	
	
	// 1. 회원가입시 ID중복체크를 위한 SQL : public int confirmId(String id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; //초기화
		//중복인지 아닌지 sql로 조회 : SELECT * FROM MEMBER WHERE ID='aaa';
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // 2단계
			pstmt = conn.prepareStatement(sql); // 3단계
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4,5단계
			
			if(rs.next()) { // true면 우리가 원하지 않는 경우(중복된 경우) 
				result = MEMBER_EXISTENT; //이미 있는 ID
			}else {
				result = MEMBER_NONEXISTENT; //사용 가능한 ID
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
	
	// 2. 회원가입 : pulbic int joinMember(MemberDto dto)
	public int joinMember(MemberDto dto) {
		int result = FAIL; //항상 최악의 변수로 초기화
		// dto를 DB에 insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS) " + 
				"    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setTimestamp(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());
			result = pstmt.executeUpdate(); //성공이면 result에 1, 실패면 catch로 떨어질 것
			System.out.println(result==SUCCESS? "회원가입 성공" : "회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : " + dto.toString()); //toString 오버라이드해서 toString 안써도 되긴함
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return result;
	}
	
	// 3. 로그인(id/pw) : pulblic int loginCheck(String id, String pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID; //초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID, PW FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // 2단계
			pstmt = conn.prepareStatement(sql); // 3단계
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4,5단계
			if(rs.next()) { // 유효한 ID를 입력 
				//유효한 ID라면 pw를 제대로 친 경우, 아닌경우 구분을 해야한다.
				String pwDB = rs.getString("pw"); //db에서 가져온 pw
				if(pwDB.contentEquals(pw)) { // pw가 맞는지 체크
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			}else { // 유효하지 않은 ID(ID가 없는 경우)
				result = LOGIN_FAIL_ID;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
		
	}
	
	// 4. ID로 dto가져오기(로그인 성공 되었을 때 할 액션)(dto 자체를 세션에다가) : public MemberDto getMember(String id)
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection(); // 2단계
			pstmt = conn.prepareStatement(sql); // 3단계
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //4,5단계
			if(rs.next()) {
				// 너무 길어서 dto에서 가져온 뒤에 변환
				// String id; 어차피 매개변수에 있기 때문에
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Date rdate = rs.getDate("rdate");
				String address = rs.getString("address");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3,
									gender, email, birth, rdate, address);
			}else {
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
	// 5. 회원정보 수정 : public int modifyMember(MemberDto dto)
	public int modifyMember(MemberDto dto) {
		int result = FAIL; //항상 최악의 변수로 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?, " + 
				"                NAME=?, " + 
				"                PHONE1 = ?, " + 
				"                PHONE2 = ?, " + 
				"                PHONE3 = ?, " + 
				"                GENDER = ?, " + 
				"                EMAIL = ?, " + 
				"                BIRTH = ?, " + 
				"                ADDRESS = ? " + 
				"            WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "정보수정 성공" : "정보수정실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("정보수정 실패 : " + dto.toString()); 
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}

}
