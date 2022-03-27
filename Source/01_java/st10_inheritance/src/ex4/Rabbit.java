package ex4;
//Animal로 부터 speed, running(), stop() 상속 받음
public final class Rabbit extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+30); // speed += 30;
		System.out.println("마구 뛰어오. 현재 속도 : "+speed);
	}
}
