package com.lec.ex1_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		// String�� new�� �������� �ʰ� " "�� ����� ���ڿ� ����� �̿�. �ڵ����� �������� String ��ü�� �̹� �����ϴ��� Ȯ���ϰ�
		// �����ϸ� �̹� �����ϴ� �ּҸ� ����Ŵ. �������� ������ String ��ü ����. new�ϸ� ������ ����� �ֱ�� ��
		String str3 = new String("Java"); //������ ����(new �̱� ������)
		if(str1==str2) {
			System.out.println("str1�� str2�� ���� �ּҰ�");
		}else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ�");
		}
		if(str1.equals(str2)) {
			System.out.println("���� ���ڿ�");
		}
		System.out.println(str1==str3? "str1�� 3�� ���� �ּ�":"str1�� 3�� �ٸ��ּ�");
		System.out.println(str2.equals(str3)? "���� ��Ʈ��" : "�ٸ� ��Ʈ��");
		
	}
}