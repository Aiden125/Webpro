package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 수를 입력받아 입력받은 수(3) ! = 3*2*1(팩토리얼 계산하는 메소드 이용)
public class Ex06_factorial {
	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("양수를 입력하세요 : ");
			su = sc.nextInt();			
		}while(su<=0);
		long result = factorial(su);
		System.out.printf("입력하신 %d != %d", su, result);
	}
	
	private static long factorial(int su) { // su가 1초과인 경우 su*facorial(su-1)
		if(su==1) {
			return 1;
		}else {
			return su*factorial(su-1);
		}
	}
//	private static long factorial(int su) {
//		int result = 1;
//		for(int i=su ; i>=1 ; i--) {
//			result *= i;
//		}
//		return result;
//	}
}




