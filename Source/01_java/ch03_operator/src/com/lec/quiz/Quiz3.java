package com.lec.quiz;
// (Quiz 3) �μ��� �Է¹޾� 
// �� ���� ������ ����� O�� X�� ���.
// ù��° ���� �� ū�� ����� O�� X�� ����Ѵ�.

import java.util.Scanner;

//����ڷκ��� �Է¹��� ���� 3�� ������� ���� ���
public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�� ���� ���� ���ʴ�� �Է��Ͻÿ� : ");
		int su = scanner.nextInt(); //����ڷκ��� ���� �Է� �ޱ�
		int su2 = scanner.nextInt();
		String result = su == su2 ? "o" : "x";
		String result2 = su > su2 ? "o" : "x";
		System.out.println("�� ���� ������?" + result);
		System.out.println("ù ��° ���� �� ū��?" + result2);
		scanner.close();
	}
}
