package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03_equal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fn;
		do {
			System.out.println("I : input | U : update | X : exit");
			fn = scanner.next(); // XxIiUu, etc
			switch(fn) {
			// iȤ�� I�Է��ϴ� ���
			case "i":
			case "I":
				System.out.println("input ���� ���� ��");
				break;
			
			// uȤ�� U �Է��ϴ� ���
			case "u":
			case "U":
				System.out.println("update ���� ���� ��");
			}
		}while(!fn.equalsIgnoreCase("x")); //x Ȥ�� X�� �Է����� ������ ��� �ݺ�. ���� �ϳ��� �Է��ϸ� ��������
		System.out.println("DONE");
	}
}
