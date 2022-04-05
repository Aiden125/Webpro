package com.lec.ex4.quiz;
//TestMain1.java에서, N이나 n을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를
//ArrayList에 받고, N이나 n을 입력할 경우 가입한 모든 회원들의 정보를 아래와 같이
//콘솔창에 출력하는 프로그램을 구현하시오

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//어레이 리스트<데이터형태> 변수 = new arraylist<데이터형태>();
		ArrayList<Member> members = new ArrayList<Member>();

		while (true) {
			System.out.println("이름을 입력해주세요 (중지는N/n)");
			String name = sc.next();
			//만일 사용자가 n을 누를경우 while문을 빠져나가게 하기 위함
			if (name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("번호를 입력해주세요 ");
			String number = sc.next();
			System.out.println("주소를 입력해주세요");
			sc.nextLine(); //버퍼지우는 용도
			String address = sc.nextLine();
			//입력받은 데이터를 ArrayList Member에 add해주기(새로 지정한members객체 이용)
			members.add(new Member(name, number, address));
		}
		if (members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다");
		}
		for (Member m : members) {
			System.out.println(m);
			
		}sc.close();
		
	}
}
