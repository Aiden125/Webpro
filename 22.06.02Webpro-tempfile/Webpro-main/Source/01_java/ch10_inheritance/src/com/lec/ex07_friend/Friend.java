package com.lec.ex07_friend;
// this. : �� ��ü��
// this() : �� Ŭ������ ������ �Լ�
public class Friend {
	private String name;
	private String tel; // 010�� �� �� 0�� �츮���� �� String���� �ؾ��� Friend f = new Friend("ȫ�浿");
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this(); //Friend ȣ��. ���� this(); �Ⱦ��� Friend ȣ��x
		this.name = name;
		System.out.println("�Ű����� �ϳ�¥�� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name); //Friend(name) ȣ��. ���� this(name)�Ⱦ��� Friend ȣ��x
		this.tel = tel;
		System.out.println("�Ű����� �� �� ¥�� ������ �Լ�");
	}
	public String infoString() {
		return "[�̸�]"+name + " [��ȭ]" + tel;
	}
}
