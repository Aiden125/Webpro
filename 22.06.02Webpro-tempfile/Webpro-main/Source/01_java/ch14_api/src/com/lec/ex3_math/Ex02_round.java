package com.lec.ex3_math;
// Math.ceil(�ø� �Ǽ���) => double�� return
// Math.round(�ݿø��� �Ǽ���) => int�� return
// Math.floor(���� �Ǽ���) => double�� return
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("�Ҽ������� �ݿø�, �ø�, ����");
		System.out.println("9.15�� �ø� : "+Math.ceil(9.15)); //ceil�� returnŸ���� double
		System.out.println("9.15�� �ø� : "+(int)Math.ceil(9.15)); //����ȯ ���Ѵٸ� ����� ����ȯ Ȱ��
		System.out.println("9.15�� �ݿø� "+Math.round(9.15));
		System.out.println("9.15�� �ݿø� "+Math.floor(9.15));
		System.out.println("�Ҽ��� �� ��°�ڸ����� �ݿø�, �ø�, ����"); // �ڹٿ��� ������ �ѹ��� ����ϴ°� ���⿡ �ܸӸ��� ��������
		System.out.println("9.15�� �ø� : "+Math.ceil(9.15 * 10)/10); //9.15�� ��°�ڸ����� �ݿø��ϱ����ؼ� *10�� �ߴٰ� ��� �� �ٽ� 10���� ����
		System.out.println("9.15�� �ݿø� : "+Math.round(9.15*10)/10.0); //���� ���� ����̳�, double�� return���ֱ� ���ؼ� 10.0���� ����
		System.out.println("9.15�� ���� : "+Math.floor(9.15*10)/10.0); //�����ϰ� double���� ����
		
		System.out.println("���� �ڸ����� �ݿø�, �ø�, ����");
		System.out.println("85�� �ø� : "+(int)Math.ceil(85/10.0)*10); //90.0�� ���·� ���ϸ� int����� ��
		System.out.println("85�� �ݿø� : "+Math.round(85/10.0)*10);
		System.out.println("85�� ���� : "+(int)Math.floor(85/10.0)*10); //80.0�� ���·� ���ϸ� int����� ��
		
	}
}
