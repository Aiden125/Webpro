package com.lec.ex08_superdot;
// super. : �� �θ����
// super() : �� �θ���� ������ �Լ� - Ư�� �󵵰� ���⿡ �� �˾Ƶα�
public class ParentClass {
	private int i = 20;
	public ParentClass() {
		System.out.println("ParentClass ������");
	}
	public void method() {
		System.out.println("ParentClass�� method super���� ���̴� i�� "+i);
	}
	//i�� private�� ����Ǿ��ֱ⿡ getI�� ���� ���ϰ��� �޾ƿ;� ��
	public int getI() {
		return i;
	}
}