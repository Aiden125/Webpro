package com.lec.ex03_shape;
// Shape�� ���ؼ� Rectangle(w,h), Triangle(w,h), Circle(r)�� �� ������ ��
public abstract class Shape {
	public void draw() {
		String ClassName = this.getClass().getName(); //com.lec.ex3_shape.Circle
		System.out.println(ClassName+"������ �׷���");
	}
	public abstract double computeArea(); //�߻� �޼ҵ�
}
