package ex2_shape;

public class Recktangle extends Shape {
	private int w;
	private int h;
	
	public Recktangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double computeArea() {
		return w*h;
	}

}
