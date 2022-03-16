package com.st.operator;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요 : ");
		int su = scanner.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		int su2 = scanner.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		int su3 = scanner.nextInt();
		
		int sum = (su+su2+su3);
		System.out.printf("합계=%d\t", sum);
		double Avg = (su+su2+su3)/3;
		System.out.printf("평균=%.2f", Avg);
		scanner.close();
	}
}