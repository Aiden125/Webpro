package com.lec.ex5_scanner;
import java.util.Scanner;
//���۸� �������ϴ��� �������� �Ǵ��ؼ� nextLine�ѹ� �� �־ \n�����ָ� �ǰ�
//�������� �Ǵ� ����� �� �ʿ��� ��ŭ�� �־�� �� ����
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�ּҸ� �Է��ϼ���");
		scanner.nextLine();
		String address = scanner.nextLine();
		System.out.println("�Է��Ͻ� �ּҴ�" + address);
		
		System.out.println("�̸��� �Է��ϼ���");
		String name = scanner.next();
		System.out.println("�Է��Ͻ� �̸��� " + name);
	}
}
