package com.lec.ex1_tryCatch;

import java.util.Scanner;
// ���ܰ� �߻� ������ ������ try{}�� ���Ѵ�.
// ��ȣ ������ catch�� �ְ� �߻��� �� �ִ� ������ �־��ش�
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��Ģ������ �� ù��° ����?");
		int i = scanner.nextInt(); //���� �߻� ����
		System.out.println("��Ģ���� �� �ι�° ����?");
		int j = scanner.nextInt(); //���� �߻� ����
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		try {
			System.out.println("i / j = " + (i/j)); // ���� �߻� ����			
		}catch(ArithmeticException e) { //���ܰ� �߻��� ��� ��ȸ������ ������ ����  Arith�� ���콺 ���ٳ��� ��Ʈ��+t������ ��Ӱ��赵�� ����
			System.out.println("���� �޽���"+e.getMessage()); //���ܰ� �߻��� ��� ���ܸ޽����� ���
			//e.printStackTrace(); //���ܻ����� �ڼ��� ��� ���ϴ� ��� ���� �Լ�. ������ �״�� �߻��� ��ó�� ������ ������ �� �Ⱦ��� ��
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
