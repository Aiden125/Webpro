package com.lec.ex3_exceptionExs;

public class Ex03_numberformat {
	public static void main(String[] args) {
		//int i = Integer.parseInt(""); //��Ʈ���� ���ڷ� ��ȯ �ȵǸ�, ���ܹ߻�
		int i = Integer.parseInt("100 ".trim()); //��Ʈ���ȿ� �����̽��� ���� ���������� �ȵǱ� ������ Ʈ���̿�
		System.out.println(i);
	}
}
