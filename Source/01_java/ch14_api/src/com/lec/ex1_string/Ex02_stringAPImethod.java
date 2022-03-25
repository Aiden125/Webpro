package com.lec.ex1_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "                       ja  va         ";
		System.out.println("1�� �� "+str1.concat(str2)); // ���ڿ����� �Լ��� ���ϴ� �� abcXabcABCXabc
		System.out.println("2�� �� "+str1.substring(3)); // 3��°���� ������ Xabc
		System.out.println("3�� �� "+str1.substring(3,5)); // 3��°���� 5��°�ձ���Xa
		System.out.println("4�� �� "+str1.length()); //���ڱ���7
		System.out.println("5�� �� "+str1.toUpperCase()); //�빮�ڷ� ABCXABC
		System.out.println("6�� �� "+str1.toLowerCase()); //�ҹ��ڷ� abcxabc
		System.out.println("7�� �� "+str1.charAt(3)); //3��° ���ڸ� ��ȯ 'X'
		System.out.println("8�� �� "+str1.indexOf('b')); //ù��° b���ڰ� ������ ��ġ�� �ε���
		System.out.println("9�� �� "+str1.indexOf('b', 3)); //3��°���� �˻��ؼ� ù��°'b'��ġ �ε��� 5 (�ε����� ó�����ͽ���)
		System.out.println("10�� �� "+str1.indexOf("abc")); //ù��° "abc" ������ ��ġ �ε��� 0
		System.out.println("11�� �� "+str1.indexOf("abc", 3)); //3��°���� �˻��ؼ� ù��° "abc" ������ ��ġ�ε��� 4(�ε����� ó�����ͽ���)
		System.out.println("12�� �� "+str1.indexOf('z')); //������ -1
		System.out.println("13�� �� "+str1.lastIndexOf('b')); //������'b'��ġ ��ȯ
		System.out.println("14�� �� "+str1.lastIndexOf('b',3)); //3��°���� �� ������ b
		
		System.out.println("15�� : "+str1.equals(str2)); //str1�� str2�� ���� ���ڿ����� false
		System.out.println("16�� : "+str1.equalsIgnoreCase(str2)); //��ҹ��� ���о��� �� true
		System.out.println("17�� : "+str3.trim()); //�յ� ��������. �߰������� ����x
		System.out.println("18�� : "+str1.replace('a', '9')); //'a'�� '9'�� ���� 9bcX9bc
		System.out.println("19�� : "+str1.replace("abc", "������")); //"abc"�� "������"�� ����
		System.out.println("20�� : "+str3.replace(" ", "")); // ������ ���� ��
		System.out.println("21�� : "+str1.replaceAll("abc", "ZZZ")); // "abc"�� "ZZZ"��
		
		//����ǥ���� https://goo.gl/Hlntbd
		//����ǥ���� ������ https://www.nextree.co.kr/p4327
		String str = "�ȳ�Hello";
		System.out.println(str.replaceAll("[a-zA-Z]", ""));//���ĺ��� ""�� ����
		System.out.println(str.replaceAll("[��-�R]", ""));//�ѱ۹��ڸ� ""�� ����
		//���ڿ� �޼ҵ�� ���ڿ��� ���� ����
		System.out.println("stsr1 = "+str1);
		System.out.println("stsr2 = "+str2);
		System.out.println("stsr3 = "+str3);
	}
}
