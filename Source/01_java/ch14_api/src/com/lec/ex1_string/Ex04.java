package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		String su;
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է����ּ��� ");
		System.out.println("ex)123456-123456");
		su = sc.next();
		if(su.substring(7,8).equals("1")) {
			System.out.println("����");
		}else if(su.substring(7,8).equals("3")) {
			System.out.println("����");
		}else if(su.substring(7,8).equals("2")) {
			System.out.println("����");
		}else if(su.substring(7,8).equals("4")) {
			System.out.println("����");
		}
		sc.close();
	}
}
