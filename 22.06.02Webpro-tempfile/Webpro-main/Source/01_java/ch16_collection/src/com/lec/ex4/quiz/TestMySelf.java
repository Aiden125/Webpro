package com.lec.ex4.quiz;
//test1, 2���ļ� ��ȭ��ȣ�� �ߺ��Ǹ� ����Ǵ� arraylist������
import java.util.ArrayList;
import java.util.Scanner;

public class TestMySelf {
	public static void main(String[] args) {
		ArrayList<Member> member = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("�̸��� �Է����ּ��� (������N/n)");
			String name = sc.next();
			
			if(name.equalsIgnoreCase("n")) {
				System.out.println("�����մϴ�");
				break;
			}
			System.out.println("��ȣ�� �Է����ּ���");
			String tel = sc.next();
			//�ߺ��Ȱ� �����Ϸ��� �ϳ��� �����ؼ� ã�Ƴ�����. 
			//Map���� ���� ��ȿ������ ����� ������ ��������� ������ ��
			if
			System.out.println("�ּҸ� �Է����ּ���");
		}
	}
}

//������ �����
//���� ������ ��(�Է�-�о���̱�) ��Ʈ�� ���� �� �� �������� ��Ʈ�� ���� ����(��Ʈ���� �ݴ´�)
//������ ������ ��(���-��������) ���Ϸ� ��Ʈ�� �����ϰ� ���� �� ������ ���� ����(��Ʈ���� �ݴ´�)