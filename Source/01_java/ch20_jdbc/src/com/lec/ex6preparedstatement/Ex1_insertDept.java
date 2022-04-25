package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// preparedStatement를 써서 insert 받기. 인서트할 때는 ,단순히 stmt쓰는거보다 나음
public class Ex1_insertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		
		//추가할 데이터 받기
		System.out.println("추가할 부서번호?");
		int deptno = scanner.nextInt();
		System.out.println("추가할 부서이름?");
		String dname = scanner.next();
		System.out.println("추가할 부서 위치?");
		String loc = scanner.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//prepared 쓸 때는 정보(스캐너) 받기전에 sql문 써도 됨 상관x. (물음표로 처리할거기 때문에)
		//아래 문장을 변환하는 격
		//String sql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+"' WHERE DEPTNO="+deptno;
		String sql = "INSERT INTO DEPT VALUES(?, ?, ?)";
		
		//여기까지가 1단계시작하기 전에 해야될것들
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); //prepared에서는 sql넣어줘야함 SQL전송객체 ??어디로 전송하는가(자바로 전송하는게 맞나?)
			//stmt = createstatement(); 이전에는 이런식으로 썼었음
			
			pstmt.setInt(1,  deptno); // sql의 첫번째 물음표에 인트값으로 deptno로 세팅하겠다.
			pstmt.setString(2,  dname); // 두번째 물음표 String값으로 dname으로 세팅하겠다. String이면 알아서 싱글커테이션 부여해줌
			pstmt.setString(3,  loc); // 세번째 물음표 String값으로 loc으로 세팅하겠다. String이면 알아서 싱글커테이션 부여해줌
			int result = pstmt.executeUpdate(); // sql이랑은 다름 괄호 비워주기.
			//in result = stmt.executeUpdate(sql);
			
			System.out.println(result > 0? deptno+"번 입력성공":"입력 실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
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
}
