package ex2_shape;

public abstract class Shape {
	public void draw() {
		String ClassName = this.getClass().getName();
		System.out.println(ClassName+"도형을 그려요");
	}
	//추상메소드
	public abstract double computeArea();
}
