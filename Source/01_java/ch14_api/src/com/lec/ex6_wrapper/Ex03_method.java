package com.lec.ex6_wrapper;

public class Ex03_method {
	public static void main(String[] args) {
		System.out.println("��Ʈ���� ������ �ٲٴ� �Լ� : Integer.parseInt(���ڿ�)");
		// ���� ���ϴ°� �̷��� �� �� int i = "10"; ��, ��Ʈ��10�� �Է��ص� ����i�� ����� ���� ��
		int i = Integer.parseInt("10");
		System.out.println(i);
		System.out.println("������ ��Ʈ������ �ٲٴ� �Լ� : ");
		// ���� ���ϴ� �� �̷��� �� �� String monthStr = 12;
		String monthStr = ""+12; //�̷��Ե� ������ ��. ��Ʈ��+���� == ��Ʈ�� �̱� ������
		monthStr = String.valueOf(12); //�̰� ����
		System.out.println(monthStr);
	}
}
