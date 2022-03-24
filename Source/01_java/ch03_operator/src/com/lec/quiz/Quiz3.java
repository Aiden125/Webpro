package com.lec.quiz;
// (Quiz 3) 두수를 입력받아 
// 두 수가 같은지 결과를 O나 X로 출력.
// 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.

import java.util.Scanner;

//사용자로부터 입력받은 수가 3의 배수인지 여부 출력
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("두 가지 수를 차례대로 입력하시오 : ");
		int su = scanner.nextInt(); //사용자로부터 정수 입력 받기
		int su2 = scanner.nextInt();
		String result = su == su2 ? "o" : "x";
		String result2 = su > su2 ? "o" : "x";
		System.out.println("두 수가 같은가?" + result);
		System.out.println("첫 번째 수가 더 큰가?" + result2);
		scanner.close();
	}
}
