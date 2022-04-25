package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// 입력, 직업별조회, 전체조회, 직업리스트

//Dao = 구현할 기능을 실질적으로 담아
//너무 긴 자바 명령문을 줄여주기위한
//java, db사이의 중간 다리 역할을 하는 클래스(알맹이)

public class PersonDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//가독성을 높이기 위해서 성공, 실패 케이스에 대한 변수 지정
	public static int SUCCESS=1;
	public static int FAIL = 0;
	
	//INSTANCE는 static으로 정의되었기에 한번 값이 변하면 계속 메모리에 상주하면서 값이 안바뀜 즉,
	//한 번 생성된 이후부터는 null이 아닌 특정 주소값을 가지고 있는 상태로 계속 있게됨
	private static PersonDao INSTANCE=null;
	public static PersonDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	
	public PersonDao() {
		try {
			//1단계는 기본생성자에서 한번만
			Class.forName(driver); //(1단계)
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1번 입력(매개변수dto, return SUCCESS/FAIL)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		
		// dto안의 값을 DB에 insert (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO PERSON "
				+ "VALUES (PERSON_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger"); //(2)
			pstmt = conn.prepareStatement(sql); //(3)
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
			// ?? 쓰면 안되는지? System.out.println(result>0?"insert성공":"insert실패");
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
	// 2번 직업별 조회(매개변수 jname, return PersonDto ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>(); // 변수 리턴하기 위해 정의
		// 직업별 조회 결과를 dtos에 add (2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT PNAME, JNAME , KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"        FROM PERSON P, JOB J" + 
				"        WHERE P.JNO=J.JNO AND JNAME=?" + 
				"        ORDER BY SUM DESC) A";
		try {			
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) { // while문이 안돌면 rs.next()에 일치하는 정보가 하나도 없다는 것
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				//jname은 매개변수로 입력되기에 다시 정의 x
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank,pname,jname,kor,eng,mat,sum));
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

	// 3번 전체조회(매개변수x, return ArrayList<PersonDto>
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>(); //변수만들고 변수 리턴
		
		// 전체조회 결과를 dtos에 add
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT PNAME, JNAME , KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"        FROM PERSON P, JOB J" + 
				"        WHERE P.JNO=J.JNO" + 
				"        ORDER BY SUM DESC) A";
		
		// 2단계~7단계 진행
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRank(rs.getString("rank"));
				dto.setPname(rs.getString("pname"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
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
		return dtos;
	}
	// 4번 직업명 리스트 조회(return Vector<String>)
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>();
		jnames.add(""); // 0번째 인덱스에는 "" 이유:콤보박스 첫번째는 빈스트링, 그 밑부터 직업명이 보이게 하려고(편하니까)
		
		// 직업명리스트를 DB에서 검색한 후 jname에 add(2~7단계)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT JNAME FROM JOB";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
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
		return jnames;
	}
}
