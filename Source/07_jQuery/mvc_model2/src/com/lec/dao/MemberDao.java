package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.MemberDto;


public class MemberDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public static final int EXISTENT = 0;
	public static final int NON_EXISTENT = 1;
	private DataSource ds = null;
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g"); 
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	// 1. 중복 아이디 조회
	public int idCheck(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT;
			}else {
				result = NON_EXISTENT;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	// 2. 로그인
	public int login(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID=? AND mPW=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
			}else {
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	// 3. 회원가입
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER(mID, mPW, mNAME, mEMAIL, mPHOTO, " + 
				"                mBIRTH, mADDRESS) " + 
				"            VALUES(?, ?, ?, ?, ?, " + 
				"                    ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, dto.getMphoto());
			pstmt.setDate(6, dto.getMbirth());
			pstmt.setString(7, dto.getMaddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 4. 중복 이메일 조회
		public int emailCheck(String memail) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM MEMBER WHERE mEMAIL=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memail);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = EXISTENT;
				}else {
					result = NON_EXISTENT;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result;
		}
		
	// 5. mid로 DTO 가져오기
	public MemberDto getMemberDto(String mid) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	
	// 6. 회원정보 수정
	public int memberModify(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET mPW=?, " + 
				"                  mNAME=?, " + 
				"                  mEMAIL=?, " + 
				"                  mPHOTO=?, " + 
				"                  mBIRTH=?, " + 
				"                  mADDRESS=? " + 
				"            WHERE mID=? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMpw());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getMemail());
			pstmt.setString(4, dto.getMphoto());
			pstmt.setDate(5, dto.getMbirth());
			pstmt.setString(6, dto.getMaddress());
			pstmt.setString(7, dto.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	// 7. 회원리스트 보기
	public ArrayList<MemberDto> memberList(int startRow, int endRow){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM (SELECT ROWNUM RN, A.* " + 
				"            FROM (SELECT * FROM MEMBER ORDER BY mID ) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				dtos.add(new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + dtos);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	
	// 8. 등록된 회원수
	public int totMember() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) TOTCNT FROM MEMBER";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt("totcnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + totCnt);
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totCnt;
	}
}
