package com.lec.ex02_protectedmember;
// ������ - ������ - �޼ҵ� - �������̵� �޼ҵ� - getter&setter ���� ��Ű��
public class SuperIJ {
	private int i;
	private int j;
	//��ӹ��� Ŭ�������� SuperŬ����(�θ� Ŭ����) ������ �Լ��� ���� ȣ��
	public SuperIJ() {
		System.out.println("�Ű����� ���� SuperIJ ������ �Լ�");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ��� i, j�ʱ�ȭ");
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	protected int getI() {
		return i;
	}
}
