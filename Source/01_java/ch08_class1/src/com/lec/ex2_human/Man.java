package com.lec.ex2_human;
// Man Kin = new Man(22, 160, 50.3, "010-2222-2222");
// Man Kin = new Man(22, 160, 50.3);
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	
	//����Ʈ ������ �Լ� 
	public Man() {} 
	//�Ű����� �Ѱ�¥�� ������ �Լ�
	public Man(int age) {
		this.age = age;
	}
	
	//��ȭ��ȣ�� �� 3��¥�� ������ �Լ�
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");
	}
	//��ȭ��ȣ�� ������ 4��¥�� ������ �Լ�
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");
	}
}
