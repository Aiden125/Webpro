package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;
// 예외 : ArithmeticException, InputMismatchException
// * try안에서는 try를 넣지 않는다
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("사칙연산을 할 첫번째 수는?");
				i = scanner.nextInt(); //예외 발생 가능
				break; //i에 정수를 제대로 넣으면 break를 통해 dowhile 문을 빠져나가라의 의미
			}catch(InputMismatchException e) { //만약에 에러 종류를 모르겠다하면 Exception 쓰면 됨
				System.out.println("예외 메시지 " + e.getMessage());
				System.out.println("정수를 반드시 입력하세요");
				scanner.nextLine(); //버퍼에 남아있는걸 지우기 위한 문장
			}
		}while(true);
		
		System.out.println("사칙연산 할 두번째 수는?");
		//여러 문장을 묶어서 try절 안으로 감싸는 것도 가능
		try {
			j = scanner.nextInt();
			System.out.println("i = " + i + ", j = " + j);
			System.out.println("i * j = " + (i*j));
			System.out.println("i / j = " + (i/j));	
			//트라이절 안에 또 다른 트라이절 예외가 필요하면 캐치를 여러번 써서 잡아내는게 가독성면에서 우수
			//대신 캐치절에서 순서를 잘 구성해줘야함
		}catch(InputMismatchException e) {
			System.out.println("예외 메시지"+e.getMessage());
			System.out.println("두번째 수를 잘못 입력하시면 1로 초기화 됨");
		}catch(ArithmeticException e) {
			System.out.println("두번째 예외 메시지"+e.getMessage()); 
		}catch(Exception e) {
			System.out.println("모든 예외 객체 커버"+e.getMessage());
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
