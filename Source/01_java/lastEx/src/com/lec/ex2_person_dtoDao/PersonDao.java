package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// �Է�, ��������ȸ, ��ü��ȸ, ��������Ʈ

//Dao = ������ ����� ���������� ���
//�ʹ� �� �ڹ� ��ɹ��� �ٿ��ֱ�����
//java, db������ �߰� �ٸ� ������ �ϴ� Ŭ����(�˸���)

public class PersonDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//�������� ���̱� ���ؼ� ����, ���� ���̽��� ���� ���� ����
	public static int SUCCESS=1;
	public static int FAIL = 0;
	
	//INSTANCE�� static���� ���ǵǾ��⿡ �ѹ� ���� ���ϸ� ��� �޸𸮿� �����ϸ鼭 ���� �ȹٲ� ��,
	//�� �� ������ ���ĺ��ʹ� null�� �ƴ� Ư�� �ּҰ��� ������ �ִ� ���·� ��� �ְԵ�
	private static PersonDao INSTANCE=null;
	public static PersonDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	
	public PersonDao() {
		try {
			//1�ܰ�� �⺻�����ڿ��� �ѹ���
			Class.forName(driver); //(1�ܰ�)
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 1�� �Է�(�Ű�����dto, return SUCCESS/FAIL)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		
		// dto���� ���� DB�� insert (2~7�ܰ�)
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
			// ?? ���� �ȵǴ���? System.out.println(result>0?"insert����":"insert����");
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
	// 2�� ������ ��ȸ(�Ű����� jname, return PersonDto ArrayList<PersonDto>)
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>(); // ���� �����ϱ� ���� ����
		// ������ ��ȸ ����� dtos�� add (2~7�ܰ�)
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
			while(rs.next()) { // while���� �ȵ��� rs.next()�� ��ġ�ϴ� ������ �ϳ��� ���ٴ� ��
				String rank = rs.getString("rank");
				String pname = rs.getString("pname");
				//jname�� �Ű������� �ԷµǱ⿡ �ٽ� ���� x
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

	// 3�� ��ü��ȸ(�Ű�����x, return ArrayList<PersonDto>
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>(); //��������� ���� ����
		
		// ��ü��ȸ ����� dtos�� add
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT PNAME, JNAME , KOR, ENG, MAT, KOR+ENG+MAT SUM" + 
				"        FROM PERSON P, JOB J" + 
				"        WHERE P.JNO=J.JNO" + 
				"        ORDER BY SUM DESC) A";
		
		// 2�ܰ�~7�ܰ� ����
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
	// 4�� ������ ����Ʈ ��ȸ(return Vector<String>)
	public Vector<String> jnamelist() {
		Vector<String> jnames = new Vector<String>();
		jnames.add(""); // 0��° �ε������� "" ����:�޺��ڽ� ù��°�� ��Ʈ��, �� �غ��� �������� ���̰� �Ϸ���(���ϴϱ�)
		
		// ��������Ʈ�� DB���� �˻��� �� jname�� add(2~7�ܰ�)
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
