package com.lec.ex03_point;

public class TestMain {
	public static void main(String[] args) {
		Point point = new Point(5,5); //x,y�� ����(�ʱ�ȭ)
		point.setX(10); //x�� 10���� �� ����
		point.pointPrint();
		System.out.println(point.infoString());
		System.out.println(point.toString()); //System.out.println(point);�� ���� toString()�� �ڵ����� �ٴ� ���̳� ��������
		//�ٷ� �� ����� ���� ��. ��, toString�� ���� ���ظ� �� �ϰ� �־�� �Ѵٴ� ��
		System.out.println(point); //�� �� ��� ���� ���� toString �������̵��ؼ� ���� ���� ����
		Point3D point3d = new Point3D(1, 2, 3);
		System.out.println(point3d.info3DString());
		System.out.println(point3d.infoString()); // ����� ������ ��� ����� �޼ҵ带 �� ���
	}
}
