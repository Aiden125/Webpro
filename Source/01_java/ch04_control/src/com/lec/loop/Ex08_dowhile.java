package com.lec.loop;

import java.util.Scanner;

// 짝수를 입력받는 프로그램을 구현해보자
public class Ex08_dowhile {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("짝수를 입력하시오 : ");
			num = sc.nextInt();
		}while(num%2!=0);
		System.out.println("입력하신 수는 짝수"+num+"입니다.");
		sc.close();
	}
}
