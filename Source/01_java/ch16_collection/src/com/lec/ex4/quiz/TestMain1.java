package com.lec.ex4.quiz;
//TestMain1.java����, N�̳� n�� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)��
//ArrayList�� �ް�, N�̳� n�� �Է��� ��� ������ ��� ȸ������ ������ �Ʒ��� ����
//�ܼ�â�� ����ϴ� ���α׷��� �����Ͻÿ�

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//��� ����Ʈ<����������> ���� = new arraylist<����������>();
		ArrayList<Member> members = new ArrayList<Member>();

		while (true) {
			System.out.println("�̸��� �Է����ּ��� (������N/n)");
			String name = sc.next();
			//���� ����ڰ� n�� ������� while���� ���������� �ϱ� ����
			if (name.equalsIgnoreCase("n")) {
				break;
			}
			System.out.println("��ȣ�� �Է����ּ��� ");
			String number = sc.next();
			System.out.println("�ּҸ� �Է����ּ���");
			sc.nextLine(); //��������� �뵵
			String address = sc.nextLine();
			//�Է¹��� �����͸� ArrayList Member�� add���ֱ�(���� ������members��ü �̿�)
			members.add(new Member(name, number, address));
		}
		if (members.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�");
		}
		for (Member m : members) {
			System.out.println(m);
			
		}sc.close();
		
	}
}
