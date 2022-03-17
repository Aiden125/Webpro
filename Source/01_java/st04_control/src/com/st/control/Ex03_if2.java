package com.st.control;

import java.util.Scanner;

public class Ex03_if2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하시오 : ");
		int score = sc.nextInt();
		if((90 <= score) && (score <= 100)) {
			System.out.println("A학점");
		}else if((80 <= score) && (score < 90)) {
			System.out.println("B학점");
		}else if((70 <= score) && (score < 80)) {
			System.out.println("C학점");
		}else if((60 <= score) && (score < 70)) {
			System.out.println("D학점");
		}else if((0 <= score) && (score < 60)) {
			System.out.println("F학점");
		}else {
			System.out.println("Wrong");
		}
		sc.close();
	}

}

