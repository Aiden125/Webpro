package com.lec.ex6_wrapper;

import java.util.Scanner;

//사용자로부터 스트링을 입력받아 정수로 변환
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		String numStr = sc.nextLine();
		numStr = numStr.trim(); //좌우 space 제거
		numStr = numStr.replaceAll("[a-zA-Z가-힣ㄱ-ㅎ]", ""); //문자 제거. 즉, 숫자만 남게하기
		// numStr = numStr.replaceAll("\\D", ""); //문자 제거. 즉, 숫자만 남게하기
		int num = Integer.parseInt(numStr); // 스트링을 정수로 바꾸는 함수 Inegre.parseInt(문자열)
		System.out.println("변형된 정수는 : "+num);
		sc.close();
	}
}
