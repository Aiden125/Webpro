package com.lec.ex03_shape;
// Shape를 통해서 Rectangle(w,h), Triangle(w,h), Circle(r)를 잘 쓰고자 함
public abstract class Shape {
	public void draw() {
		String ClassName = this.getClass().getName(); //com.lec.ex3_shape.Circle
		System.out.println(ClassName+"도형을 그려요");
	}
	public abstract double computeArea(); //추상 메소드
}
