package ex2_shape;

public class TestMain {
	public static void main(String[] args) {

		Shape[] shape = {
				new Recktangle(10, 5),
				new Triangle(10, 5),
				new Circle(10)
				};
		
		for (Shape s : shape) {
			s.draw();
			System.out.println("°è»ê ³ÐÀÌ´Â"+s.computeArea());
		}
	}
}
