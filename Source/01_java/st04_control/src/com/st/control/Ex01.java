package com.st.control;

import java.util.Scanner;
//���� �Է¹޾� ���밪���� ��ȯ�Ͻÿ�
public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.println("���� �Է��Ͻÿ�");
		num1 = sc.nextInt();
		if (num1 >= 0) {
			System.out.println(num1);
		} else {
			System.out.println(num1*-1);
		}
		sc.close();
	}

}
