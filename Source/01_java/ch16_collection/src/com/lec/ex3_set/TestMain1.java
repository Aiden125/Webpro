package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> members = new ArrayList<Member>();

		while (true) {
			System.out.println("�̸��� �Է����ּ��� ������N/n");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("��ȣ�� �Է����ּ��� ");
			String number = sc.next();
			System.out.println("�ּҸ� �Է����ּ���");
			sc.nextLine();
			String address = sc.nextLine();
			members.add(new Member(name, number, address));				
		}
		if(members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�");
		}
		for(Member m : members) {
			System.out.println(members);
			
		}
	

	}
}
