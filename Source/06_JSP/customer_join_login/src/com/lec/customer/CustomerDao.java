package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
	public static final int SUCCES = 1; // 회원가입 성공, 실패 리턴
	public static final int FAIL = 0; // 회원가입 성공, 실패 리턴
	public static final int CUSTOMER_EXISTENT = 0; // 중복된 ID
	public static final int CUSTOMER_NONEXISTENT = 1; // 사용가능한 ID
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	public static final int LOGIN_FAIL = 0; // 로그인 실패
	
	//싱글톤
	private static CustomerDao instance;
	public static CustomerDao getInstance() {
		if(instance==null) {
			instance = new CustomerDao();
		}
		return instance;
	}
	private CustomerDao() {}
	
	//conn 리턴 함수
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		
		return conn;
	}
	
	
	// 1. 중복확인
	public int confirmCustomer(String cid) {
		int result = CUSTOMER_EXISTENT; // 실패값으로 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE cID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 결과가 있다면 중복.
				result = CUSTOMER_EXISTENT;
			}else { // 없다면 가입가능
				result = CUSTOMER_NONEXISTENT;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"중복조회 실패");
		} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		return result;
	}
	
	
	// 2. 회원가입
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL,"
				+ "			cEMAIL,cADDRESS, cGENDER, cBIRTH, cRDATE) "  
				+ "  VALUES(?, ?, ?, ? ,"
				+ " 		?, ?, ?, ?, SYSDATE)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setString(7, dto.getCgender());
			pstmt.setDate(8, dto.getCbirth());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCES? "회원 가입 성공" : "회원 가입 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage()+ " 회원가입 실패");
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				
			}
		}
		return result;
	}
	
	// 3. 로그인(cid/cpw)
	public int loginCustomer(String cid, String cpw) {
		int result = LOGIN_FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cPW FROM CUSTOMER WHERE cID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 유효한 id
				String pwDB = rs.getString("cpw"); //db에서 가져온 pw
				if(pwDB.contentEquals(cpw)) {
					result = LOGIN_SUCCESS;
				}else { // pw 틀린 경우
					result = LOGIN_FAIL;
				}
			}else { // id 유효하지 않은 경우 
				result = LOGIN_FAIL;
			}
		} catch (Exception e) {
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
		return result;
	}
	
	// 4. ID로 dto 가져오기 dto자체를 세션에 넣기
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE cID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				// cid는 매개변수, 데이터는 dto 적힌 순서대로
				String cpw = rs.getString("cpw");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String caddress = rs.getString("caddress");
				String cgender = rs.getString("cgender");
				Date cbirth = rs.getDate("cbirth");
				Date crdate = rs.getDate("crdate");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, caddress, cgender, cbirth, crdate);
			}
		} catch (Exception e) {
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
	
	
	// 5. 회원정보 수정
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET cPW=?, " + 
				"                    cNAME=?, " + 
				"                    cTEL=?, " + 
				"                    cEMAIL=?, " + 
				"                    cADDRESS=?, " + 
				"                    cGENDER=?, " + 
				"                    cBIRTH=? " + 
				"                WHERE cID=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setString(6, dto.getCgender());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCid());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCES? "정보수정 성공" : "정보수정 실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
}
