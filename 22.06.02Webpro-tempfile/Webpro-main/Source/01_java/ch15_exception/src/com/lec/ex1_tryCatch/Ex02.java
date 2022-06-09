package com.lec.ex1_tryCatch;

import java.util.Scanner;
// 예외가 발생 가능한 문장을 try{}로 감싼다.
// 괄호 끝에는 catch를 넣고 발생할 수 있는 변수를 넣어준다
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사칙연산을 할 첫번째 수는?");
		int i = scanner.nextInt(); //예외 발생 가능
		System.out.println("사칙연산 할 두번째 수는?");
		int j = scanner.nextInt(); //예외 발생 가능
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		try {
			System.out.println("i / j = " + (i/j)); // 예외 발생 가능			
		}catch(ArithmeticException e) { //예외가 발생할 경우 우회적으로 수행할 로직  Arith에 마우스 갖다놓고 컨트롤+t누르면 상속관계도가 나옴
			System.out.println("예외 메시지"+e.getMessage()); //예외가 발생될 경우 예외메시지만 출력
			//e.printStackTrace(); //예외사항을 자세히 출력 원하는 경우 쓰는 함수. 에러를 그대로 발생한 것처럼 나오기 때문에 잘 안쓰는 편
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
