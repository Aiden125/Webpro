package com.lec.ex6_wrapper;

import java.util.Scanner;

//����ڷκ��� ��Ʈ���� �Է¹޾� ������ ��ȯ
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���");
		String numStr = sc.nextLine();
		numStr = numStr.trim(); //�¿� space ����
		numStr = numStr.replaceAll("[a-zA-Z��-�R��-��]", ""); //���� ����. ��, ���ڸ� �����ϱ�
		// numStr = numStr.replaceAll("\\D", ""); //���� ����. ��, ���ڸ� �����ϱ�
		int num = Integer.parseInt(numStr); // ��Ʈ���� ������ �ٲٴ� �Լ� Inegre.parseInt(���ڿ�)
		System.out.println("������ ������ : "+num);
		sc.close();
	}
}
