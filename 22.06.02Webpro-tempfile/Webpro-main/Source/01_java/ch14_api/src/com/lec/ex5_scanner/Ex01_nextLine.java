package com.lec.ex5_scanner;
import java.util.Scanner;
//��� - buffer�� �Է¹޴� ����
//nextInt(); -> ���� �޴� ��
//next(); -> String �޴� �� but, ���� ������ �ȵ�
//nextLine(); -> String �޴� ��(��������) but, �ռ� ����Ŀ��� \n �����ִ� �� �� üũ�ϰ� ���������.
public class Ex01_nextLine {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = scanner.nextInt(); // '\n' ���� ���ڸ� return�ϰ� ���۸� ����
		System.out.println("�Է��Ͻ� ���̴�"+age);
		
		System.out.print("�̸��� �Է��ϼ���");
		String name = scanner.next(); //�ݵ�� �����̽��� �ȵ��� �Է������ ���� ���� ��ĳ��.next�� ù��° ����� �ձ����� ���
		System.out.println("�Է��Ͻ� �̸���"+name);
		
		System.out.println("�ּҸ� �Է��ϼ��� :");
		//�ٷ� �Ʒ� ������ �ֳ� �ȳֳ��� ���� ������ �߻��ϳ� ���ϳİ� ������
		scanner.nextLine(); // ���Ϳ� �����ִ� \n�� ����� ����
		//
		String address = scanner.nextLine(); // ���͸� ġ����� ���� return
		System.out.println("�Է��Ͻ� �ּҴ�"+address);
		scanner.close();
	}
	//�ش���� ��� ��ĳ�� ��Ʈ����� 2 0 \n ����. 20�� ���� ���Ͱ� ����
	//���ӽ�ĳ���� ��� \n ȫ �� �� \n �� ����Ǹ� �տ� �ִ� \n�� �����ϰ� ȫ �� �� �������ϰ� ������ \n�� ���� ��
	//���� \n�� �ϳ� ���� �ִ� ��Ȳ�̸�, ��ĳ�� �ؽ�Ʈ������ ��� \n�� �տ��� �����ϱ� ������ �ƹ��͵� ������ �ȵ� ��, ������ �ǹ����� \n�� ���������
}
