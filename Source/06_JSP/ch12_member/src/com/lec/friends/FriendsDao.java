package com.lec.friends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FriendsDao {
	public static final int SUCCESS = 1; // 성공시 리턴
	public static final int FAIL = 0; // 실패시 리턴
	
	//싱글톤
	private static FriendsDao instance;
	public static FriendsDao getInstance() {
		if(instance==null) {
			instance = new FriendsDao();
		}
		return instance;
	}
	
	//외부에서 new 못하게 private으로
	private FriendsDao() {
	}
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
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
}



