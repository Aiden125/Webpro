package com.lec.ex1_string;

import java.util.Scanner;

// ��ȭ��ȣ �޾�, �Է¹��� ��ȭ��ȣ, ¦����° ����, �Ųٷ�, ��ȭ��ȣ ���ڸ�, ��ȭ��ȣ ���ڸ�
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("��ȭ��ȣ�� �Է��ϼ���(010-2211-1234����) x�� �Է½� ����˴ϴ�.");
			String tel = sc.next();
			//����ڰ� x�� �Է��ϸ� ���ߵ���
			if(tel.equalsIgnoreCase("x"))break;
			System.out.println("�Է��� ��ȭ��ȣ" + tel);
			for (int i = 0; i < tel.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tel.charAt(i)); // ¦����° ���� ���
				} else {
					System.out.print(' ');
				}
			}
			System.out.println(); // ����
			System.out.println("���ڸ� �Ųٷ� : ");
			for (int i = tel.length() - 1; i >= 0; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println(); // ����
			String pre = "��ȭ��ȣ ���ڸ�";
			String post = "��ȭ��ȣ ���ڸ�";

			int first = tel.indexOf('-');
			int last = tel.lastIndexOf('-');

			pre = tel.substring(0, first);
			post = tel.substring(last + 1);

			String mid = tel.substring(first + 1, last);
			System.out.println("���� ���ڸ� : " + pre);
			System.out.println("���� ���ڸ� : " + post);
			System.out.println("���� �߰��ڸ� : " + mid);
		}
	}
}

//String tel;
//Scanner sc = new Scanner(System.in);
//
//	System.out.println("��ȭ��ȣ�� �Է��ϼ��� ex)031-234-5678");
//	tel = sc.next();
//	System.out.println("�Է��� ��ȭ��ȣ : "+tel);	
//	System.out.println("¦����° ���ڿ�");
//	for(int i=12 ; i>=0 ; i--) {
//	}
//	System.out.println("���ڸ� �Ųٷ�");
//	System.out.println("��ȭ��ȣ �� ���ڸ���");
//	System.out.println((tel.substring(0,3)));
//	System.out.println("��ȭ��ȣ ���ڸ��� : ");
//	System.out.println((tel.substring(8,12)));
//	sc.close();
//}
