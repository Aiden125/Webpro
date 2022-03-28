package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 받아, 입력받은 전화번호, 짝수번째 문자, 거꾸로, 전화번호 앞자리, 전화번호 뒷자리
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("전화번호를 입력하세요(010-2211-1234형식) x를 입력시 종료됩니다.");
			String tel = sc.next();
			//사용자가 x를 입력하면 멈추도록
			if(tel.equalsIgnoreCase("x"))break;
			System.out.println("입력한 전화번호" + tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i)); // 짝수번째 문자 출력
				} else {
					System.out.print(' ');
				}
			}
			System.out.println(); // 개행
			System.out.println("문자를 거꾸로 : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println(); // 개행
			String pre = "전화번호 앞자리";
			String post = "전화번호 뒷자리";

			int first = tel.indexOf('-');
			int last = tel.lastIndexOf('-');

			pre = tel.substring(0, first);
			post = tel.substring(last + 1);

			String mid = tel.substring(first + 1, last);
			System.out.println("전번 앞자리 : " + pre);
			System.out.println("전번 뒷자리 : " + post);
			System.out.println("전번 중간자리 : " + mid);
		}
	}
}

//String tel;
//Scanner sc = new Scanner(System.in);
//
//	System.out.println("전화번호를 입력하세요 ex)031-234-5678");
//	tel = sc.next();
//	System.out.println("입력한 전화번호 : "+tel);	
//	System.out.println("짝수번째 문자열");
//	for(int i=12 ; i>=0 ; i--) {
//	}
//	System.out.println("문자를 거꾸로");
//	System.out.println("전화번호 맨 앞자리는");
//	System.out.println((tel.substring(0,3)));
//	System.out.println("전화번호 뒷자리는 : ");
//	System.out.println((tel.substring(8,12)));
//	sc.close();
//}
