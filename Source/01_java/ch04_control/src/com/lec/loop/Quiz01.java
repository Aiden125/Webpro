package com.lec.loop;
//1~10���� ���� ���غ���(�������� ������ 1�� �ʱ�ȭ)
public class Quiz01 {
	public static void main(String[] args) {
		int tot = 1; //������ ����
		for(int i=2 ; i<=10 ; i++) {
			tot = (tot*i);// tot = tot * i;
		}
		System.out.println("1~10���� �������� "+tot);
	}
}
