package com.lec.ex1_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str.hashCode());
		str = str+"d";
		System.out.println(str.hashCode());
		
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.append("def"); // ������ "abc"�� "def"�� �߰� : abcdef
		System.out.println("strBuilder : "+strBuilder); // abcdef
		strBuilder.insert(3, "AAA"); // 3��°�� "AAA" �߰�(�ε��� 4�� ��ġ)
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.delete(3, 5);//3��°���� 5��° �� ���� �����ض�
		System.out.println("strBuilder : "+strBuilder);
		strBuilder.deleteCharAt(3); // 3��° ���ڸ� ���� = delete(3,4)
		System.out.println("strBuilder : "+strBuilder);
		System.out.println("�ؽ��ڵ� ��� : "+strBuilder.hashCode());
	}
}
