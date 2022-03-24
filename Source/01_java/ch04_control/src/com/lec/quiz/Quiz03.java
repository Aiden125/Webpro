package com.lec.quiz;

import java.util.Scanner;

//사용자로부터 국어, 영어, 수학 점수를 입력받아 각 과목별 점수가 평균 이상인지 이하인지 출력해 보자
public class Quiz03 {

	public static void main(String[] args) {
		int num1, num2, num3;
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		num1 = sc.nextInt();
		System.out.print("영어 점수 : ");
		num2 = sc.nextInt();
		System.out.print("수학 점수 : ");
		num3 = sc.nextInt();
		double avg = (num1 + num2 + num3) / 3.0;
		if (num1 >= avg) {
			System.out.println("국어 점수 평균이상");
		} else {
			System.out.println("국어 점수 평균이하");
		}
		if (num2 >= avg) {
			System.out.println("영어 점수 평균이상");
		} else {
			System.out.println("영어 점수 평균이하");
		}
		if (num3 >= avg) {
			System.out.println("수학 점수 평균이상");
		} else {
			System.out.println("수학 점수 평균이하");
		}
		sc.close();
	}

}
