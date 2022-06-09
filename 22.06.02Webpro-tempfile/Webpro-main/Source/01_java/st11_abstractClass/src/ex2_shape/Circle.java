package ex2_shape;

public class Circle extends Shape {
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public double computeArea() {
		return 3.14*r*r;
	}

}
