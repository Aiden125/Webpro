package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BoardDto;

public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	
	//싱글톤
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		if(instance==null) {
			instance = new BoardDao();
		}
		return instance;
	}
	private BoardDao() {}
	
	
	//커넥션 객체를 받아오는 함수 : getConnection()
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// 1. 글갯수 출력 : public int getBoardTotalCnt()
	public int getBoardTotalCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM BOARD";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next(); //이걸 해야 한줄을 가져오고 다음줄을 포인터로 가리킴
			totalCnt = rs.getInt(1); //1열의 데이터를 int값으로 받아옴
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalCnt;
	}
	
	// 2. 글목록 출력 : public ArrayList<BoardDto> 몇개있는지 모르니까 리스트로
	public ArrayList<BoardDto> listBoard(int startRow, int endRow){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM RN, A.* " + 
				"            FROM ( SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num			= rs.getInt("num");
				String writer	= rs.getString("writer");
				String subject	= rs.getString("subject");
				String content	= rs.getString("content");
				String email	= rs.getString("email");
				int readcount	= rs.getInt("readcount");
				String pw		= rs.getString("pw");
				int ref			= rs.getInt("ref");
				int re_step		= rs.getInt("re_step");
				int re_indent	= rs.getInt("re_indent");
				String ip		= rs.getString("ip");
				Timestamp rDate = rs.getTimestamp("rdate");
				dtos.add(new BoardDto(num, writer, subject, content, email,
							readcount, pw, ref, re_step, re_indent, ip, rDate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	// 3. 원글 쓰기 : public int insertBoard(BoardDto dto)
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL,"
				+ "				PW, REF, RE_STEP, RE_INDENT, IP) " + 
				"    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, " + 
				"            	?, (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 4. 글번호로 글 한줄 출력하기 : public BoardDto getBoardOneLine(int num)
	// 파라미터는 String으로 날아오기 때문에 매개변수를 int 로 지정하면 형 변환 해주어야함
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery(); // 반드시 1줄이나 0줄(num이 프라이머리 키 이기에)
			if(rs.next()) {
				// int num		= rs.getInt("num");
				String writer	= rs.getString("writer");
				String subject	= rs.getString("subject");
				String content	= rs.getString("content");
				String email	= rs.getString("email");
				int readcount	= rs.getInt("readcount");
				String pw		= rs.getString("pw");
				int ref			= rs.getInt("ref");
				int re_step		= rs.getInt("re_step");
				int re_indent	= rs.getInt("re_indent");
				String ip		= rs.getString("ip");
				Timestamp rDate = rs.getTimestamp("rdate");
				dto = new BoardDto(num, writer, subject, content, email,
						readcount, pw, ref, re_step, re_indent, ip, rDate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	
	// 5. 조회수 update : pulbic void readcountUp(int num)
	public void readcountUpt(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 6. 글 수정 : public int updateBoard(BoadrDto dto)
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET SUBJECT = ?, " + 
				"                CONTENT = ?, " + 
				"                EMAIL = ?, " + 
				"                PW = ?, " + 
				"                IP = ? " + 
				"            WHERE NUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPw());
			pstmt.setString(5, dto.getIp());
			pstmt.setInt(6, dto.getNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 7. 글 삭제 : public int deleteBoard(int num, String pw)
	public int deleteBoard(int num, String pw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE NUM=? AND PW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 8. 순서 업데이트 하기 답변글 저장전에 할 것 step a 
	private void preReplyStepA(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET RE_STEP=RE_STEP+1 WHERE REF=? AND RE_STEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			int result = pstmt.executeUpdate(); // 첫번째 답글이라면(내릴 자식이 없다면) re_step을 안바꿀수도 있음
			System.out.println(result + "개 조정");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 9. 답변글 입력
	public int reply(BoardDto dto) {
		int result=FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// num, writer, subject, content, email, pw, ref, re_step, re_indent, ip
		// 사용자로부터 입력받을 답변글 내용 : writer, subject, content, email, pw
		// 원글에 대한 정보 : ref, re_step, re_indent
		// 시스템으로 부터 저장될 정보 : ip
		String sql = "INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) " + 
				"    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), ?, ?, ?, ?, ?, " + 
				"            ?, ?, ?, ?)";
		preReplyStepA(dto.getRef(), dto.getRe_step()); //답변글 입력전 step a 실행해주기
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setInt(6, dto.getRef());
			pstmt.setInt(7, dto.getRe_step()+1);
			pstmt.setInt(8, dto.getRe_indent()+1);
			pstmt.setString(9, dto.getIp());
			result = pstmt.executeUpdate(); // 성공적으로 인서트 안되면 캐치절로 빠짐
			// DB에 저장 될 dto 내용(위에서 dto업데이트 해주는거처럼 DB저장값도 똑같이)
			dto.setRe_step(dto.getRe_step()+1);
			dto.setRe_indent(dto.getRe_indent()+1);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "답변글 실패");
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
