//��Ű����, Ŭ������, ������, �������Լ�(�����ε�), �޼ҵ�, setter&getter
package com.lec.ex1_square;

public class Square {
	private int side;
	//������ �Լ��� �ƿ� ���� ���� JVM�� ����Ʈ �����ڸ� ��������
	//(�ƹ� �͵� ���� �ʴ� �Ű����� ���� ������)
	
	//�Ű����� ���� ������
	//������ �Լ� : returnŸ���� ���� class��� ���� �Լ�
	public Square() { 
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
	}
	
	//�Ű� ���� �ִ� ������ �Լ� �뵵 : ������ �ʱ�ȭ
	public Square(int side) { 
		this.side = side;
		System.out.println("�Ű� ���� �ִ� ������ �Լ� ȣ��. side �ʱ�ȭ");
	}
	
	//�޼ҵ�
	public int area() {
		return side*side;
	}
	// setter & getter
	// setS������ ġ�� �ڵ��ϼ� �ϸ��
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
