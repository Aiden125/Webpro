package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 1. 회원가입(Phone, Name 입력)
		public int insertCustomer(String phone, String name) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO CUSTOMER (NO, PHONE, NAME) VALUES (CUSTOMER_SQ.NEXTVAL,?, ?)";
			
			try {
				conn=DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phone);
				pstmt.setString(2, name);
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
		

		// 2. 폰뒤4자리(FULL) 검색
		public ArrayList<CustomerDto> phoneGetCustomers(String phone){
			ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT NO, PHONE, NAME, POINT FROM CUSTOMER WHERE PHONE LIKE '%'||?";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no = rs.getInt("no");
					phone = rs.getString("phone");
					String name = rs.getString("name");
					int point = rs.getInt("point");
					dtos.add(new CustomerDto(no, phone, name, point));
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

		// 3.전체출력
		public ArrayList<CustomerDto> getCustomers(){
			ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT NO, PHONE, NAME, POINT FROM CUSTOMER";
			
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int no = rs.getInt("no");
					String phone = rs.getString("phone");
					String name = rs.getString("name");
					int point = rs.getInt("point");
					dtos.add(new CustomerDto(no, phone, name, point));
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
		
}
