package com.lec.ex08_superdot;

//super. : �� �θ����
//super() : �� �θ���� ������ �Լ�
public class ChildClass extends ParentClass { // ParentClass - i, method()
	private int i = 99; // �̷��� �����ϸ� �ڽ�Ŭ������ i ���ǰ� ��

	public ChildClass() {
		System.out.println("ChildClass ������");
	}

	@Override
	public void method() {
		System.out.println("ChildClass�� method");
		super.method();
		System.out.println("ChildClass���� super�� i=" + super.getI() + ", Child���� i=" + i); // super.getI()�� �Ἥ �θ���� I�� ����� �� ����
	}
	@Override
	public int getI() {
		return i;
	}
}
