package com.lec.ex02_protectedmember;

public class Child extends SuperIJ {
	private int total;

	public Child() {
		System.out.println("�Ű����� ���� Child ������");
	}
	// Child c = new Child(10, 20);
	// �ڽ� Ŭ���������� �θ� Ŭ������ i, j ��밡��
	public Child(int i, int j) {
		setI(i);
		setJ(j);
		System.out.println("�Ű����� �ִ� Child ������");
	}
	public void sum() {
		total = getI() + getJ(); // total = i+j; ���� �ٷ� i+j�� ���� ����. �޾ƿ;��ϴ� ���̱� ������
		System.out.printf("�� ��ü�� i=%d, j=%d", getI(), getJ());
		System.out.printf("�� ��ü�� total=%d", total);
	}
}
