package ex4;
// Animal�� ���� speed, running(), stop() ��� ����
public class Dog extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed() + 10); // speed += 10;
		System.out.println("������ ���� �پ��. ���� �ӵ� : "+ getSpeed())
		;
	}
}