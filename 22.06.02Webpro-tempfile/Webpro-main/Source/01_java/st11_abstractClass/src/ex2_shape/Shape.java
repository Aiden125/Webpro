package ex2_shape;

public abstract class Shape {
	public void draw() {
		String ClassName = this.getClass().getName();
		System.out.println(ClassName+"������ �׷���");
	}
	//�߻�޼ҵ�
	public abstract double computeArea();
}
