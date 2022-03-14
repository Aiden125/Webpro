package com.lec.quiz;

import java.util.Scanner;

//가위바위보 중 하나를 내고 낸 것을 출력하세요
public class Quiz04 {
	public static void main(String[] args) {
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.print("0, 1, 2 중 하나를 입력하시오 : ");
		num1 = sc.nextInt();
		if (num1 == 0) {
			System.out.println("가위");
		} else if (num1 == 1) {
			System.out.println("바위");
		} else if (num1 == 2) {
			System.out.println("보");
		} else {
			System.out.println("Wrong");
		}
		sc.close();
	}
}
