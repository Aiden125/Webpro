package ex4;

public class TestMain {
	public static void main(String[] args) {
		Animal[] animals = {
				new Dog(),
				new Rabbit()};
		for(Animal animal : animals) {//Ÿ���� Animal �̱⿡ Animal�� ���� ���� ���� �ϳ� ���� �� �迭 �Լ� ����
			animal.running();
			animal.running();
			animal.stop();
		}
//		animals[0].running();
//		animals[0].running();
//		animals[0].stop();
//		animals[1].running();
//		animals[1].running();
//		animals[1].stop();
	}
}