package com.lec.ex06_override;
//�� ����� ���� ��Ű���� �� �ʿ�� ������ import�� �� ����� ��
public class ParentClass {

	public ParentClass() {//�����ε� ParentClass�� �ߺ��Ǿ�����(�Ű������� ���� Ÿ���� �޸��ϸ鼭)
		System.out.println("�Ű����� ���� ParentClass ������");
	}
	public ParentClass(int i) {//�����ε� ParentClass�� �ߺ��Ǿ�����(�Ű������� ���� Ÿ���� �޸��ϸ鼭)
		System.out.println("�Ű����� �ִ� ParentClass ������");
	}
	public void method1() {
		System.out.println("ParentClass�� method1()�� �Լ�");
	}
	public void method2() {
		System.out.println("ParentClass�� method2()�� �Լ�");
	}
}
