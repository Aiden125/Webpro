package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
	String tel;
	Scanner sc = new Scanner(System.in);
	
		System.out.println("��ȭ��ȣ�� �Է��ϼ��� ex)031-234-5678");
		tel = sc.next();
		System.out.println("�Է��� ��ȭ��ȣ : "+tel);	
		System.out.println("¦����° ���ڿ�");
		for(int i=12 ; i>=0 ; i--) {
			tel(i);
		}
		System.out.println("���ڸ� �Ųٷ�");
		System.out.println("��ȭ��ȣ �� ���ڸ���");
		System.out.println((tel.substring(0,3)));
		System.out.println("��ȭ��ȣ ���ڸ��� : ");
		System.out.println((tel.substring(8,12)));
	
	}

}
