package com.lec.ex;
//��������� : + - * / %(������)
public class Ex01 {
	public static void main(String[] args) {
		int n1 = 33, n2=10;
		int result; // + - * %�� ���
		double resultdouble; // /�� ���
		//println ���·� �ۼ� �غ� ��
		result = n1 + n2;
		System.out.println(n1 + "+" + n2 + "=" +result);
		/*
		result = n1+n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result); // 33+10=43
		*/
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 % n2; //������
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		resultdouble = (double)n1 / n2;
		System.out.println(n1 + "/" + n2 + "=" +resultdouble);
		if(n1%2==0) {
			System.out.println("n1�� ¦��");
			System.out.println("n1�� ¦���� ����");
		}else
			System.out.println("n1�� Ȧ��");
		if(n1%5==0){
			System.out.println("n1�� 5�� ���");
		}else
			System.out.println("n1�� 5�� ����� �ƴ�");
	}
}
