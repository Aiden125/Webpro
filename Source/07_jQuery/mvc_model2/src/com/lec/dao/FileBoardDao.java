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

import com.lec.dto.FileBoardDto;

public class FileBoardDao {
	public final static int FAIL = 0;
	public final static int SUCCESS = 1;
	DataSource ds = null;
	
	private static FileBoardDao instance = new FileBoardDao();
	public static FileBoardDao getInstance() {
		return instance;
	}
	
	private FileBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g"); 
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	// 1. 글목록 listBoard
	public ArrayList<FileBoardDto> boardList(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM (SELECT ROWNUM RN, A.* " + 
				"            FROM(SELECT F.*, mNAME, mEMAIL " + 
				"                FROM FILEBOARD F, MEMBER M " + 
				"                WHERE F.mID = M.mID " + 
				"                ORDER BY FGROUP DESC, fSTEP) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				dtos.add(new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname, memail));
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
		return dtos;
	}
	
	
	// 2. 전체갯수
	public int boardTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
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
		return totCnt;
	}
	
	
	// 3. 원글쓰기(insert)
	public int writeBoard(String mid, String ftitle, String fcontent, String ffilename,
			String fip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, " + 
				"                fGROUP, fSTEP, fINDENT, fIP) " + 
				"        VALUES(FILE_SEQ.NEXTVAL, ?, ?, ?, ?, " + 
				"                FILE_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, ftitle);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setString(5, fip);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "원글쓰기 성공" : "원글쓰기 실패");
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
	
	
	
	// 4. 답변글 쓰기전 스텝
	private void beforeWrite(int fgroup, int fstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSTEP = fSTEP +1 WHERE fGROUP=? AND fSTEP>?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			pstmt.executeUpdate();
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
	}
	
	
	// 5. 답변글 쓰기
	public int reply(FileBoardDto dto) {
		int result = FAIL;
		beforeWrite(dto.getFgroup(), dto.getFstep());
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, " + 
				"                fGROUP, fSTEP, fINDENT, fIP) " + 
				"        VALUES(FILE_SEQ.NEXTVAL, ?, ?, ?, ?, " + 
				"                ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getFtitle());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFfilename());
			pstmt.setInt(5, dto.getFgroup());
			pstmt.setInt(6, dto.getFstep());
			pstmt.setInt(6, dto.getFindent());
			pstmt.setString(7, dto.getFip());
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
	
	
	// 6. fid로 조회수 올리기
	private void hitUp(int fid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			pstmt.executeUpdate();
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
	
	// 7. 글 상세보기
	public FileBoardDto contentView(int fid) {
		FileBoardDto dto = null;
		hitUp(fid); // 글 상세보기시 자동적으로 hitUp
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, mNAME, mEMAIL FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fID=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mid = rs.getString("mid");
				String ftitle = rs.getString("ftitle");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				Date frdate = rs.getDate("frdate");
				int fhit = rs.getInt("fhit");
				int fgroup = rs.getInt("fgroup");
				int fstep = rs.getInt("fstep");
				int findent = rs.getInt("findent");
				String fip = rs.getString("fip");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				dto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip, mname, memail);
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
	
	// 8. 글 상세보기(조회수 안올리고)
		public FileBoardDto getFile(int fid) {
			FileBoardDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT F.*, mNAME, mEMAIL FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String mid = rs.getString("mid");
					String ftitle = rs.getString("ftitle");
					String fcontent = rs.getString("fcontent");
					String ffilename = rs.getString("ffilename");
					Date frdate = rs.getDate("frdate");
					int fhit = rs.getInt("fhit");
					int fgroup = rs.getInt("fgroup");
					int fstep = rs.getInt("fstep");
					int findent = rs.getInt("findent");
					String fip = rs.getString("fip");
					dto = new FileBoardDto(fid, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
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
		
		
		// 9. 글 수정
		public int modify(FileBoardDto dto) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE FILEBOARD SET fTITLE=?, " + 
					"                    fCONTENT=?, " + 
					"                    fFILENAME=?, " + 
					"                    fIP=? " + 
					"                WHERE fID=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getFtitle());
				pstmt.setString(2, dto.getFcontent());
				pstmt.setString(3, dto.getFfilename());
				pstmt.setString(4, dto.getFip());
				pstmt.setInt(5, dto.getFid());
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
		
		// 글 삭제하기
		public int delete(int fid) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM FILEBOARD WHERE fID=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, fid);
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
