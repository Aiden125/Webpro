package com.lec.ex6_wrapper;

import com.lec.ex4_object.Dept;
import com.lec.ex4_object.Sawon;
//equals ��, ������ �񱳸� �Ϸ��� ��üvs��ü�� �񱳸� �ؾߵǴµ� ���ʵ����� Ÿ���� ���
//�񱳰� �ȵǱ⿡ �ڹٿ��� �ڵ������� Integer���� �������ֳ� �������� �ϴ� ����� ����
public class Ex02 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("���� "+sum);
		System.out.println(i==j ? "�� int�� ����" : "�� int�� �ٸ���");
		Integer iObj = new Integer(10); // Integer iObj = 10 �̷��� �־ 10�̶�� ���� ����Ű�� �ּҸ� ���� ��ü ���� �ڵ����� ����
		Integer jObj = new Integer(10);
		sum = iObj + jObj; //�����ϰԴ� �̷��� �ص� �Ǹ�, �ڼ��ϰ� ���� �Ʒ� ������ �ڵ������� ��ȯ ���ִ� ���̳� ��������
		// sum = iObj.intValue() + jObj.intValue(); //��ü.Intvalute = �� �ȿ� �ִ� ���� ���� �������� �Լ�
		System.out.println("���� "+sum);
		System.out.println(iObj.equals(jObj) ? "�� wrapper��ü ���� ����" : "�� wrapper��ü ���� �ٸ���");
		System.out.println(iObj == jObj ? "�ּҰ� ����" : "�ּҰ� �ٸ���");
		
		
		Sawon s =new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
		//equals�� �� ���� �ּҰ��� ����Ű�� "��ü"�� ���� �ϱ⿡ i�� �������� �ϸ� �� ����. i�� ���ʵ����� ������ ������ �׳� Ư�� ���� ������ ��
		// if(s.equals(obj))
	}
}
