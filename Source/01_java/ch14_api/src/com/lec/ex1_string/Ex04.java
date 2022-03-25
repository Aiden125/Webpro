package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		String su;
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력해주세요 ");
		System.out.println("ex)123456-123456");
		su = sc.next();
		if(su.substring(7,8).equals("1")) {
			System.out.println("남자");
		}else if(su.substring(7,8).equals("3")) {
			System.out.println("남자");
		}else if(su.substring(7,8).equals("2")) {
			System.out.println("여자");
		}else if(su.substring(7,8).equals("4")) {
			System.out.println("여자");
		}
		sc.close();
	}
}
