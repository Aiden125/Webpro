package com.lec.ex6_wrapper;

//equals ��, ������ �񱳸� �Ϸ��� ��üvs��ü�� �񱳸� �ؾߵǴµ� ���ʵ����� Ÿ���� ���
//�񱳰� �ȵǱ⿡ �ڹٿ��� �ڵ������� Integer���� �������ֳ� �������� �ϴ� ����� ����
public class Ex01 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("���� "+sum);
		System.out.println(i==j ? "�� int�� ����" : "�� int�� �ٸ���");
		Double iObj = 10.1; // �Ʒ��� ��Ȯ�� ���� ��. ������ x
		Double jObj = new Double(10.1);
		sum = iObj + jObj; //�����ϰԴ� �̷��� �ص� �Ǹ�, �ڼ��ϰ� ���� �Ʒ� ������ �ڵ������� ��ȯ ���ִ� ���̳� ��������
		// sum = iObj.intValue() + jObj.intValue(); //��ü.Intvalute = �� �ȿ� �ִ� ���� ���� �������� �Լ�
		System.out.println("���� "+sum);
		System.out.println(iObj.equals(j) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
		
	}
}
