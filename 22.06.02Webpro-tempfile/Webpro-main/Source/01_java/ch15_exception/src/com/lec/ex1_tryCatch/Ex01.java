package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;
// ���� : ArithmeticException, InputMismatchException
// * try�ȿ����� try�� ���� �ʴ´�
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j=1;
		do {
			try {
				System.out.print("��Ģ������ �� ù��° ����?");
				i = scanner.nextInt(); //���� �߻� ����
				break; //i�� ������ ����� ������ break�� ���� dowhile ���� ������������ �ǹ�
			}catch(InputMismatchException e) { //���࿡ ���� ������ �𸣰ڴ��ϸ� Exception ���� ��
				System.out.println("���� �޽��� " + e.getMessage());
				System.out.println("������ �ݵ�� �Է��ϼ���");
				scanner.nextLine(); //���ۿ� �����ִ°� ����� ���� ����
			}
		}while(true);
		
		System.out.println("��Ģ���� �� �ι�° ����?");
		//���� ������ ��� try�� ������ ���δ� �͵� ����
		try {
			j = scanner.nextInt();
			System.out.println("i = " + i + ", j = " + j);
			System.out.println("i * j = " + (i*j));
			System.out.println("i / j = " + (i/j));	
			//Ʈ������ �ȿ� �� �ٸ� Ʈ������ ���ܰ� �ʿ��ϸ� ĳġ�� ������ �Ἥ ��Ƴ��°� �������鿡�� ���
			//��� ĳġ������ ������ �� �����������
		}catch(InputMismatchException e) {
			System.out.println("���� �޽���"+e.getMessage());
			System.out.println("�ι�° ���� �߸� �Է��Ͻø� 1�� �ʱ�ȭ ��");
		}catch(ArithmeticException e) {
			System.out.println("�ι�° ���� �޽���"+e.getMessage()); 
		}catch(Exception e) {
			System.out.println("��� ���� ��ü Ŀ��"+e.getMessage());
		}
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
