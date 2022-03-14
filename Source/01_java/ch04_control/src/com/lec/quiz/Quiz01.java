package com.lec.quiz;

import java.util.Scanner;

// 수를 입력받아 절대값으로 출력하시오.
public class Quiz01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.println("수를 입력하시오");
		num1 = sc.nextInt();
		if (num1 >= 0) {
			System.out.println(num1);
		} else {
			System.out.println(num1*-1);
		}
		sc.close();
	}

}
