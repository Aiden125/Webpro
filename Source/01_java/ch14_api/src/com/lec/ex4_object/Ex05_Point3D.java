package com.lec.ex4_object;

public class Ex05_Point3D {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(10);
		p1.setY(20);
		p1.setZ(5);

		// ������ �Ǿ����� �ȵǾ����� �Ǵ��ϴ� ��.
		// ���� �����µ�(�ȿ� �ִ� ����) �ּҴ� �ٸ��� ���;���. �ּҵ� ���ٸ� ������ �ƴ� ���� ���� ����Ű�� ��
		Point3D p2 = (Point3D) p1.clone();
		System.out.println(p1.equals(p2) ? "���� ��ǥ" : "�ٸ� ��ǥ");
		System.out.println(p1 == p2 ? "�����Ѱ� �ƴϰ� ���� �ּ�" : "�ٸ� �ּ�");

		// if�����ε� ���� ����(�����ߴ��� �ƴ���)
		if (p1 != p2 && p1.equals(p2)) {
			System.out.println("��������");
		} else {
			System.out.println("��������");
		}
		
		//�ؽ��ڵ�ε� ���� ����(�����ߴ��� �ƴ���)
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
