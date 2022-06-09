package com.lec.ex8_decimalformat;

import java.text.DecimalFormat;

public class Ex {
	public static void main(String[] args) {
		double num = 1234567.89;
		DecimalFormat df0 = new DecimalFormat("00000000"); //0�� 8�� ���� 8�ڸ��� �ƴ϶�� �տ��� 0�� �ٿ� ä����
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########"); //#8�ڸ� : ���ڰ� �����ص� �׳� �״�� �̾���
		System.out.println(df1.format(num));
		DecimalFormat df2 = new DecimalFormat("0,000.000"); //3�ڸ����� �޸�. �Ҽ��� 3�ڸ� ���
		System.out.println(df2.format(num)); //���� �Ҽ����� ������ ���� �Ѿ�� �ȴٸ� �� ���ڸ����� �ݿø��ؼ� �������
		DecimalFormat df3 = new DecimalFormat("#,###.##%"); //%�� ���Ǳ� ������ ���� ����Ϸ����ſ��� *100�ؼ� �������
		System.out.println(df3.format(num));
		num = 123000000000000L; //1.23E14 �̷� �������� ��ǻ�ʹ� �����
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num));
	}
}
