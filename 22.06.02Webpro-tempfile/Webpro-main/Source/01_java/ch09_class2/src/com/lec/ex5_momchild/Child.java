package com.lec.ex5_momchild;
// child first = new child(ù°	;)
public class Child {
	//������
	private String name;
	//Ŭ����������
	static MomPouch momPouch;
	
	//������(����Ʈ ������)
	public Child() {}
	//������(�Ű����� 1�� ¥�� ������)
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	
	//�޼ҵ�
	public void takeMoney(int money) {
		if(momPouch.money >= money ) {
			momPouch.money -= money;
			System.out.println(name+"��"+money+"�� �������� ���� ������"+momPouch.money+"�� ����");
		}else {
			System.out.println(name+"�� ���� ������. ���� ���� ��������"+momPouch.money+"�� �ۿ� ����");
		}
	}
}
