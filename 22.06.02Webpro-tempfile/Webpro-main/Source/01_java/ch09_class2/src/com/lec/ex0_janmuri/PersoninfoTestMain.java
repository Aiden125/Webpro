package com.lec.ex0_janmuri;
//�� Ŭ�����ȿ� Ŭ������ �� �� �ִ� ���
class PersonInfo{
	private String name;
	private int age;
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print()	{
		System.out.printf("�̸�=%s / ����=%d\n", name, age);
	}
}
public class PersoninfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("ȫ�浿", 22), new PersonInfo("�ű浿", 33)};
		//Ȯ�� for��
		for(PersonInfo p : person) {
			p.print();
		}
		//�Ϲ� for��
		for(int idx=0; idx<person.length ; idx++) {
			person[idx].print();
		}
	}
}
