package test;
//������ ���� ��°���� �������� �̸�(name)�� ��ȭ��ȣ(tel) �����͸� ����,
//������ �Լ��� ���� Ŭ������ �����ϰ� ���� ����� ����� ����ϵ��� �ڹ����α׷����� �����Ͻÿ�(40��).

//������ = �̸�(name), ��ȣ(tel)
//������ = �̸�, ��ȣ
public class Person {
	private String name;
	private String tel;
	
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "�̸� " + name +", " + "��ȭ��ȣ " + tel;
	}
	
}
