package com.lec.ex4_object;
//equals�� �Ἥ �ּҾȿ� ������ ���� ���� ���̸� ���ٰ� ������Ű�� ���� ���.
//equals �������̵� �ʿ�. Person ���� �Բ� ����
public class Ex02_PersonTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(9512051012121L);
		Person p2 = new Person(9512051012121L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		if(p1.equals(p2)) {
			System.out.println("p1�� p2�� ���� ���");
		}else {
			System.out.println("p1�� p2�� �ٸ� ���");
		}
		System.out.println(p1.equals(p3)? "����" : "�޶�");
		if(p1==p2) {
			System.out.println("p1�� p2�� ���� �ּ�");
		}else {
			System.out.println("p1�� p2�� �ٸ� �ּ�");
		}
	}
}
