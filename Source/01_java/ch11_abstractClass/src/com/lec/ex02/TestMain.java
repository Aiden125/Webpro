package com.lec.ex02;

public class TestMain {
	public static void main(String[] args) { //�߻� Ŭ������ Ÿ������ ������ ���
		SuperClass obj = new ChildClass();
		obj.method1();
		obj.method2();
	}
}
		
		
		//�߻� Ŭ������ ��ü ������ ���ϱ⿡ �͸�Ÿ������ �����ϴ°� �ƴϸ� �ȵ�. Ÿ������ ������ ����
//		SuperClass s = new SuperClass() {
//			@Override
//			public void method1() {
//				System.out.println("�͸�Ŭ���� ����");
//			}
//		};
//		s.method1();
