package com.lec.ex4.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		//�ؽø��� ��� Ű, ������� �����ؼ� ��
		HashMap<String, Member> map = new HashMap<String, Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) { 
			System.out.println("�̸��� �Է����ּ��� (������ N/n)");
			String name = sc.next();
			if(name.equalsIgnoreCase("n")) {//�ߺ��� ���� �ִ� ���
				break; //while���� ���������� ����
			}
			System.out.println("��ȣ�� �Է����ּ���");
			String number = sc.next();
			//�ѹ��� ��� �޴� ���̱� ������. �̹� �޴°��� �ʿ��� ��ȸ���� �� �̹� ����ִ� ���̸� �ߺ��ƴٴ� ��
			if(map.get(number) != null) {
				System.out.println("��ȭ��ȣ�� �ߺ��Ǿ����ϴ�.");
				continue; //�� ������ �پ�Ѱ� �ٽ� while�� �����ϰ� ����
			}
			System.out.println("�ּҸ� �Է����ּ���");
			sc.nextLine(); //���� �����
			String address = sc.nextLine();
			//�ʿ� Ű, ��� ���·� �ִµ� Ű ���� ��ȣ�� ������ ��ȣ, ����� �ֱ�
			map.put(number, new Member(name, number, address));
		}
		if(map.isEmpty()) {
			System.out.println("���Ե� ȸ���� �����ϴ�.");
		}
		//�ʿ��� ���ͷ����ʹ� Ű ���� �־��ִ� ���̰� �ٸ��÷��ǿ����� ������ Ÿ���� �ִ� ����
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			//Ű = ������ �� ���� Ű��
			String key = iterator.next();
			System.out.println(map.get(key));
		}
		sc.close();
	}
}
