package com.lec.ex1_string;
//��Ʈ�� ������ ���� �ٲ� ������ ��ü�� ���Ӱ� ����
public class Ex09_StringMemory {
	public static void main(String[] args) {
		//�̹� ������ ������ ���ڿ��� �����ϸ� ���Ŀ� ���� ������ ������ ���� �ּҸ� ����Ŵ
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("str1�� �ؽ��ڵ� : "+str1.hashCode());
		System.out.println("str2�� �ؽ��ڵ� : "+str2.hashCode());
		str1 = "Hello~";
		System.out.println("str1�� �ؽ��ڵ�(���� 1��) : "+str1.hashCode());
		str1 = "Hello~~";
		System.out.println("str1�� �ؽ��ڵ�(���� 2��) : "+str1.hashCode());
		str1 = "Hello~~~";
		System.out.println("str1�� �ؽ��ڵ�(���� 3��) : "+str1.hashCode());
	}
}
