package com.lec.ex02_protectedmember;

public class TestMain {
	public static void main(String[] args) {
		Child child = new Child(1, 2);
		System.out.println("child�� i :"+child.getI()); //get�̿� �� �޾ƿ���
		System.out.println("child�� j :"+child.getJ()); //get�̿� �� �޾ƿ���
		child.setI(10);;child.setJ(20); // set�̿� ���� �ʱ�ȭ ��Ű��
		child.sum();
	}
}
