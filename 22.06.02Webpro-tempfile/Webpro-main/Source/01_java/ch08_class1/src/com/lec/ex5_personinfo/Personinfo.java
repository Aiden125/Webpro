package com.lec.ex5_personinfo;
/*
name, age, gender�� �����ͷ� ����, ������ ������ ����ϴ� print()
�޼Ҵ��� ���� PersonInfo Ŭ������ �����ϰ� main�Լ��� �̿��Ͽ� test �����Ͻÿ�
(print() �޼ҵ� ���� ��� : �̸�=ȫ�浿, ����=20, ����=m, main �޼ҵ� �ȿ���
PersonInfo�� ��ü �ν��Ͻ��� �迭�� ������ ���ϴ�)
*/
public class Personinfo {
	//������ �ι�
	private String name;
	private int age;
	private char gender;
	//������ �ι�(�������)
	
	//����Ʈ ������
	//���콺 ��Ŭ�� �� �ҽ� ���ʷ���Ʈ form superclass
	public Personinfo() {}
	
	//���� ���ϴ� ������
	//���콺 ��Ŭ�� �� from Using Field ����
	public Personinfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	//�޼ҵ�
	public void print() {
	System.out.println("�̸�="+name+"  ����="+age+"  ����="+gender);
	}
}
