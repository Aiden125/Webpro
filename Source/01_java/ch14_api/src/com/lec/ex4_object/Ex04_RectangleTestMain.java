package com.lec.ex4_object;

public class Ex04_RectangleTestMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle();
		r1.setHeight(10); r1.setWidth(5);
		//Rectangle r2 = r1; //�̷��� ������ ���� �ּҸ� ����Ű�°��̱� ������ ������ ���� �ƴ�(r1�� ����Ű�� �ּҸ� r2�� ����Ű�� �Ǵ� ��)
		Rectangle r2 = (Rectangle) r1.clone(); //r1�� �Ȱ��� ����r2�� ����
		System.out.println("r1 : "+r1);
		System.out.println("r2 : "+r2);
		
		//������ �Ǿ����� �ȵǾ����� �Ǵ��ϴ� ��.
		//���� �����µ�(�ȿ� �ִ� ����) �ּҴ� �ٸ��� ���;���. �ּҵ� ���ٸ� ������ �ƴ� ���� ���� ����Ű�� ��
		System.out.println(r1.equals(r2)? "���� �簢��" : "�ٸ� �簢��");
		System.out.println(r1==r2 ? "�����Ѱ� �ƴϰ� ���� �ּҸ� ����Ŵ":"�ٸ� �ּҸ� ����Ŵ");
		
		//if�����ε� ���� ����(�����ߴ��� �ƴ���)
		if(r1!=r2 && r1.equals(r2)) {
			System.out.println("��������");
		}else {
			System.out.println("��������");
		}
		//�ؽ��ڵ�ε� ���� ����(�����ߴ��� �ƴ���)
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
	}
}
