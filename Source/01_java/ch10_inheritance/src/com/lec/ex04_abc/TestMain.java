package com.lec.ex04_abc;

public class TestMain {
	public static void main(String[] args) {
		S s = new S();
		// A a = new A();
		S a = new A();//��ü�� A�� �������, ������ Ÿ���� S�� ��Ȳ. ��, Ÿ��S�� ����a = ���ο� A��ü�� ������ ���̴� ��� �ǹ�
		// B b = new B();
		S b = new B();//��ü�� B�� �������, ������ Ÿ���� S�� ��Ȳ. ��, Ÿ��S�� ����b = ���ο� B��ü�� ������ ���̴� ��� �ǹ�
		S c = new C();//��ü�� C�� �������, ������ Ÿ���� S�� ��Ȳ. ��, Ÿ��S�� ����c = ���ο� C��ü�� ������ ���̴� ��� �ǹ�
		//�� A, B, C ��ü�� Ÿ���� ��� S�� �� ��Ȳ ��� S�� ����� �ޱ� �����̸�, �ݴ�� �θ� �ڽ� Ÿ������ ������ �Ұ�
		S[] arr = {s, a, b, c};
		for(S obj : arr) {
			System.out.println(obj.s);
		}
	}
}
