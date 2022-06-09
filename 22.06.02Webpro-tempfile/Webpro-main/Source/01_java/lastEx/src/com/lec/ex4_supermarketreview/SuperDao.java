package com.lec.ex4_supermarketreview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.ex3_student.Correct.StudentDao;

public class SuperDao {
	
	//드라이버 변수 넣기 및 스태틱 변수 선언
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	
	private static SuperDao INSTANCE;
	public static SuperDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SuperDao();
		}
		return INSTANCE;
	}
	
	//생성자 만들기(1단계는 여기서 실행)
	public SuperDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// 0. 레벨 이름을 검색
	public Vector<String> getLevelName() {
		Vector<String> levelnames = new Vector<String>();
		levelnames.add("");
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL";
		
		try {
			conn = DriverManager.getConnection(driver);
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				levelnames.add(rs.getString("levelName"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return levelnames;
	}
	
	
	
	// 1. cId로 검색(여러행 x)
	public SuperDto cIdgetCustomer(int cid) {
		SuperDto dto = null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-cAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    AND cid=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dto = new SuperDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp);
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
	
	
	//2. 폰뒤4자리(FULL) 검색(여러행 가능)
	public ArrayList<SuperDto> cTelGetCustomers(String ctel) {
		ArrayList<SuperDto> dtos = new ArrayList<SuperDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    AND cTEL LIKE '%'||?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				//String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new SuperDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
	
	
	
	//3.고객이름검색
	public ArrayList<SuperDto> cNameGetCustomers(String cname) {
		ArrayList<SuperDto> dtos = new ArrayList<SuperDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    AND cNAME=?" + 
				"    ORDER BY cAMOUNT DESC";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				//String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new SuperDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
	
	//4.포인트로만 구매
	public int buyWithPoint(int cid, int camount) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET cPOINT=cPOINT-? WHERE cID=?";
		
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
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
	
	//5.물품구매
	public int buy(int cid, int camount) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET cPOINT=cPOINT+(?*0.05)," + 
				"                    cAMOUNT=cAMOUNT+?," + 
				"                    LEVELNO = ( SELECT L.LEVELNO 수정될레벨" + 
				"                                FROM CUSTOMER C, CUS_LEVEL L" + 
				"                                WHERE cAMOUNT+? BETWEEN LOW AND HIGH AND cID=?)" + 
				"    WHERE cID=?";
		
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
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
	
	//6.등급별출력
	public ArrayList<SuperDto> cLevelNameGetCustomers(String levelName) {
		ArrayList<SuperDto> dtos = new ArrayList<SuperDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO" + 
				"    AND LEVELNAME=?";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				//String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new SuperDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
	
	
	
	//7.전체출력
	public ArrayList<SuperDto> getCustomer() {
		ArrayList<SuperDto> dtos = new ArrayList<SuperDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelName = rs.getString("levelName");
				int forLevelUp = rs.getInt("forLevelUp");
				
				dtos.add(new SuperDto(cid, ctel, cname, cpoint, camount, levelName, forLevelUp));
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
	
	
	//8.회원가입
	public int insertCutomer(int ctel, int cname) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CUSTOMER (cID, cTEL, cNAME)" + 
				"    VALUES (CUSTOMER_SQ.NEXTVAL, ?, ?)";
		
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctel);
			pstmt.setInt(2, cname);
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
	
	
	//9.번호수정
	public int updateCutomer(int ctel, int cid) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CUSTOMER SET cTEL=? WHERE cID=?";
		
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctel);
			pstmt.setInt(2, cid);
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
	
	
	//10.회원탈퇴
	public int deleteCutomer(int ctel) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM CUSTOMER WHERE cTEL=?";
		
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctel);
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
