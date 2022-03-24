package com.st.control;

import java.util.Scanner;

//컴퓨터와 가위바위보 게임을 하는 프로그램을 구현하시오.
//단, 사용자는 가위를 내고자 할 때는 0을 입력하고 바위를 선택하고자 할 때는 1을 입력하고,
//보를 선택하고자 할 때는 2를 입력하여 게임을 진행합니다
public class Ex04_if3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com = (int) (Math.random() * 3);
		System.out.print("0(가위), 바위(1), 보(2) 중 하나 선택");
		you = sc.nextInt(); // 정수를 입력받음
		if (you == 0) {
			System.out.println("당신은 가위");
		} else if (you == 1) {
			System.out.println("당신은 바위");
		} else if (you == 2) {
			System.out.println("당신은 보");
		} else {
			System.out.println("Wrong");
			you = 3; // 끝내기 위한 조건
		}
		if (you != 3) { // 컴퓨터가 낸 것과 승패 출력(삼항 연산자 활용 가능)
			String msg = (com == 0) ? "컴퓨터는 가위" : (com == 1) ? "컴퓨터는 바위" : "컴퓨터는 보";
			System.out.println(msg);

			if ((you + 2) % 3 == com) {
				System.out.println("당신이 이겼다.");
			} else if (you == com) {
				System.out.println("비겼다");
			} else {
				System.out.println("당신이 졌다.");
			}
			sc.close();
		}
	}
}
