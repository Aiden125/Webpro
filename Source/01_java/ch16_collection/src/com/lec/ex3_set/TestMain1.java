package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> members = new ArrayList<Member>();

		while (true) {
			System.out.println("이름을 입력해주세요 중지는N/n");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("번호를 입력해주세요 ");
			String number = sc.next();
			System.out.println("주소를 입력해주세요");
			sc.nextLine();
			String address = sc.nextLine();
			members.add(new Member(name, number, address));				
		}
		if(members.isEmpty()) {
			System.out.println("가입한 회원이 없습니다");
		}
		for(Member m : members) {
			System.out.println(members);
			
		}
	

	}
}
