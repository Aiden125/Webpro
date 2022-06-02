package com.lec.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendsDao {
	public static final int SUCCESS = 1; // 성공시 리턴
	public static final int FAIL = 0; // 실패시 리턴
	public static final int FRIENDS_EXISTENT = 0; //이미 있는 친구
	public static final int FRIENDS_NONEXISTENT = 1; //친구 추가 가능
	
	
	private Connection getConnection() throws SQLException {
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
	
	
	// 1. 전체조회하기
	public ArrayList<FriendsDto> friendsAll(){
		ArrayList<FriendsDto> dtos = new ArrayList<FriendsDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIENDS";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				dtos.add(new FriendsDto(no, name, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return dtos;
	}
	
	
	// 2. 추가하기 : public int joinFriends(Friends dto)
	public int insertFriends(FriendsDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIENDS VALUES (FRIENDS_SQ.NEXTVAL, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "친구추가 성공":"친구추가 실패");
		} catch (Exception e) {
			System.out.println("추가하기 오류"+e.getMessage());
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
	
	// 3. 검색하기
		public ArrayList<FriendsDto> searchFriends(String searchName, String searchPhone){
			ArrayList<FriendsDto> dtos = new ArrayList<FriendsDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM FRIENDS WHERE NAME LIKE '%'||?||'%' AND PHONE LIKE '%'||?||'%'";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, searchName);
				pstmt.setString(2, searchPhone);
				rs = pstmt.executeQuery();
				while(rs.next()){
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					dtos.add(new FriendsDto(no, name, phone));
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
			return dtos;
		}
}



