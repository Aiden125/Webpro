package com.lec.quiz;

import java.util.Scanner;

//���������� �� �ϳ��� ���� �� ���� ����ϼ���
public class Quiz04 {
	public static void main(String[] args) {
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.print("0, 1, 2 �� �ϳ��� �Է��Ͻÿ� : ");
		num1 = sc.nextInt();
		if (num1 == 0) {
			System.out.println("����");
		} else if (num1 == 1) {
			System.out.println("����");
		} else if (num1 == 2) {
			System.out.println("��");
		} else {
			System.out.println("Wrong");
		}
		sc.close();
	}
}
