package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1() {//�������̽� ��ü ���� �Ұ�
		InterfaceClass obj1 = new InterfaceClass(); // new Inter�� ��ü
		obj1.method1();
		obj1.method2();
		
//		��ü������ static access ����õ(�ٷ� �Ʒ� ���)
//		System.out.println(obj1.CONSTANT_NUM+"/"+obj1.CONSTANT_STRING); 
		System.out.println(InterfaceEx1.CONSTANT_NUM+"/"+InterfaceEx2.CONSTANT_STRING);
		
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass)obj2).method2();
		}
		//�� ��ȯ �ʿ���
//		System.out.println(obj2.CONSTANT_STRING);
		InterfaceEx2 obj3 = new InterfaceClass();
		//obj3.method1();
		obj3.method2();
	}
}
