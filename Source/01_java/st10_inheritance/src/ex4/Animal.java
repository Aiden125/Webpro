package ex4;

public class Animal {
	//data
	protected int speed;
	
	//method
	public void running() {
		speed += 5;
		System.out.println("�ٰ� �־��. ���� �ӵ� : " + speed);
	}
	public final void stop() { //stop method�� override ���� final�� �پ��� ����
		speed = 0;
		System.out.println("����");
	}
	
	//getter, setter
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
