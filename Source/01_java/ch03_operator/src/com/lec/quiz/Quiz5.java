package com.lec.quiz;
// (Quiz 5) ����, ����, ���� ������ ������ �Ҵ��ϰ� �� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Quiz5 {

	public static void main(String[] args) {
		// ������Ÿ�� ������ = �ʱⰪ
		int Kor = 80;
		int Eng = 90;
		int Math = 100;
		System.out.println("����="+Kor + "\t����=" +Eng + "\t����="+Math);
		int sum = Kor+Eng+Math;
		System.out.println("�հ�="+sum);
		double Avg = (Kor+Eng+Math)/3;
		System.out.printf("���=%.2f", Avg);
		// %c-����, %d-����, %f-�Ǽ�, %s-���ڿ�
		//System.out.printf("i=%d, j=%d, h=%4.2f \n", i, j, h);
	}
}
