package com.lec.quiz;

import java.util.Scanner;

public class Quiz6_ect {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� ������ �Է��ϼ��� : ");
		int su = scanner.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int su2 = scanner.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		int su3 = scanner.nextInt();
		
		int sum = (su+su2+su3);
		System.out.printf("�հ�=%d\t", sum);
		double Avg = (su+su2+su3)/3;
		System.out.printf("���=%.2f", Avg);
		scanner.close();
	}
}

