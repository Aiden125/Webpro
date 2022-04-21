package com.lec.ex3insert;
// 부서번호를 입력받아 중복체크 확인 후 입력 진행
// 중복체크 후 다시 물어보면서 시작하는 문장으로 만들어보기
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept3 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	}
}
