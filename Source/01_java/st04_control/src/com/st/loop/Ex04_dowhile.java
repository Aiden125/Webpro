package com.st.loop;
//dowhile을 활용한 가위바위보 프로그램(컴퓨터와 최소 1번의 가위바위보를 진행하라)
import java.util.Scanner;

public class Ex04_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com ;
		do {
			com = (int)(Math.random()*3);
			System.out.println("가위(0) 바위(1) 보(2) 중 하나 내세요 : ");
			you = sc.nextInt();
			if(you!=3) { // 컴퓨터가 낸 것과 승패 출력(삼항 연산자 활용 가능)
				String msg = (com==0)? "컴퓨터는 가위" : (com==1)? "컴퓨터는 바위" : "컴퓨터는 보";
				System.out.println(msg);
			
				if((you+2)%3 == com) {
					System.out.println("당신이 이겼다.");
				}else if(you == com) {
					System.out.println("비겼다");
				}else {
					System.out.println("당신이 졌다."); break;
				}
			}
		}while(true);
		System.out.println("안녕히 가세요");
	}
}

