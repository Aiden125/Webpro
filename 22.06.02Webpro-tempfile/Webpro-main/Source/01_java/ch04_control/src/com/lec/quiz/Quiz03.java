package com.lec.quiz;

import java.util.Scanner;

//����ڷκ��� ����, ����, ���� ������ �Է¹޾� �� ���� ������ ��� �̻����� �������� ����� ����
public class Quiz03 {

	public static void main(String[] args) {
		int num1, num2, num3;
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		num1 = sc.nextInt();
		System.out.print("���� ���� : ");
		num2 = sc.nextInt();
		System.out.print("���� ���� : ");
		num3 = sc.nextInt();
		double avg = (num1 + num2 + num3) / 3.0;
		if (num1 >= avg) {
			System.out.println("���� ���� ����̻�");
		} else {
			System.out.println("���� ���� �������");
		}
		if (num2 >= avg) {
			System.out.println("���� ���� ����̻�");
		} else {
			System.out.println("���� ���� �������");
		}
		if (num3 >= avg) {
			System.out.println("���� ���� ����̻�");
		} else {
			System.out.println("���� ���� �������");
		}
		sc.close();
	}

}
