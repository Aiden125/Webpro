package com.st05_array;
//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷�
public class Ex04 {
	public static void main(String[] args) {
		int a[] = {76, 45, 34, 89, 100, 50, 90, 92};
		int b[] = new int[a.length]; //�迭  a�� ���� ��ŭ�� �� ������ ����.
		
		
		// 0���� �ʱ�ȭ �Ǿ��ִ� �迭 b��  a������ �ʱ�ȭ
		for(int i=0 ; i<a.length ; i++) {
			b[i] = a[i];
			System.out.print(b[i]+" ");
		}
		
		// b�� a�� 1,2�� ���� ���� �� 2�� ������ ��ü.
		// �׳� ��ü�� �Ұ��ϱ⿡  ������ temp ���� �� �־��ٰ� ��ü
		for(int i=0 ; i<a.length ; i++) {
			for(int j=1+i ; j<a.length ; j++) {
				if(b[j] < b[i]) {
					int temp = b[j];
					b[j] = b[i];
					b[i] = temp;
				}
			}
		}
		//for Ȯ�幮�� ���� �ݺ� ���� b[]���������� ��� ��� ���
		System.out.println("\n�������� ������");
		for(int temp : b) {
			System.out.print(temp+" ");
		}
	}
}
