package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.dto.MemberDto;
import com.test.dto.MoneyDto;

public class MoneyDao {
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	
	public static MoneyDao instance = new MoneyDao();
	public static MoneyDao getInstance() {
		if(instance==null) {
			instance = new MoneyDao();
		}
		return instance;
	}
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe", "scott", "tiger");
		return con;
	}
	
	// 제품 매출 조회
	public ArrayList<MoneyDto> listProduct() {
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PCODE, SUM(PRICE) SUMPRICE FROM MONEY GROUP BY PCODE";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				int sum = rs.getInt("sumprice");
				dtos.add(new MoneyDto(pcode, sum));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally{
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtos;
	}
}
