package com.lec.ex4_object;
// ���� �μ��� ���� ����� ���θ��� �ٸ��� �Ѵٸ�? ����, �����, ��ǻ�� ��� ���� �ٸ��� �� �� �ֱ⿡ �̸� �����ؾ��Ѵ�. -��ӵ� String�� �����غ���
//Sawon s1 = new Sawon("a01", "ȫ�浿", "Dept.COMPUTER") - ���� �Ի��� (static�� �� ��� Ŭ������.��ǻ�� �̷������� ����� ���ô� �տ� �ִ� Dept.COMPUTER)
//Sawon s2 = new Sawon("a02", "������", "Dept.HUMANRECOURCES", 2022.3.24) - 3�� 24�� �Ի���
//System.out.prtinln(s1) => [���]a01 [�̸�]ȫ�浿 [�μ�]COMPUTER [�Ի���]2022��3��24��(��)
public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "ȫ�浿", Dept.COMPUTER);
		Sawon s2 = new Sawon("a02", "������", Dept.HUMANRESOURCES, 2022,3,24);
		//Tostring override�� ����ؼ� ����Ʈ
		//0. Tostring �������̵� 1. SimpleDateFormat api, 2.String �Լ�(length())�̿�
		System.out.println(s1); 
		System.out.println(s2);
		Sawon2 s3 = new Sawon2("c01", "�����", Dept2.PLANNING, 2022, 3, 10);
		System.out.println(s3);
	}
}
