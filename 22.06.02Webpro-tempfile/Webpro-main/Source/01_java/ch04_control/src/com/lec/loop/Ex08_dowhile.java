package com.lec.loop;

import java.util.Scanner;

// ¦���� �Է¹޴� ���α׷��� �����غ���
public class Ex08_dowhile {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("¦���� �Է��Ͻÿ� : ");
			num = sc.nextInt();
		}while(num%2!=0);
		System.out.println("�Է��Ͻ� ���� ¦��"+num+"�Դϴ�.");
		sc.close();
	}
}
