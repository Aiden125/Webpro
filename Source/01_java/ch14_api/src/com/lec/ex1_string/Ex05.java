package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
	String tel;
	Scanner sc = new Scanner(System.in);
	
		System.out.println("전화번호를 입력하세요 ex)031-234-5678");
		tel = sc.next();
		System.out.println("입력한 전화번호 : "+tel);	
		System.out.println("짝수번째 문자열");
		for(int i=12 ; i>=0 ; i--) {
			tel(i);
		}
		System.out.println("문자를 거꾸로");
		System.out.println("전화번호 맨 앞자리는");
		System.out.println((tel.substring(0,3)));
		System.out.println("전화번호 뒷자리는 : ");
		System.out.println((tel.substring(8,12)));
	
	}

}
