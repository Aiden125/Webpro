package com.lec.ex06_override;
// ParentClass�� method1(), method2()��� ����
// ���� method1()�� ��� �޴µ� �̰� �� ChildClass������ ���� �ٲٰ� ���� ��
public class ChildClass extends ParentClass {
	public ChildClass() {//ChildClass �����ε� ����
		System.out.println("�Ű����� ���� ChildClass ������");
	}
	public ChildClass(int i) {//ChildClass �����ε� ����
		System.out.println("�Ű����� �ִ� ChildClass ������");
	}
	public void method3() {
		System.out.println("ChildClass�� method3() �Լ�");
	}
	@Override
	public void method1() {//ParentClass�� method1 �������̵�
		System.out.println("ChildClass�� method1() �������̵�");
	}
	@Override
	public boolean equals(Object obj) { // object Ŭ������ equals �������̵�(�ٷ� �� Ŭ������ �ƴ� ����Ŭ������ �����ϴٴ� �ǹ�)
		return true;
	}
}
