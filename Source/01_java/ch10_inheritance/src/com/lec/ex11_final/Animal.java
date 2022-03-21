package com.lec.ex11_final;

public class Animal {
	protected int speed;
	public void running() {
		speed += 5;
		System.out.println("뛰고 있어요. 현재 속도 : " + speed);
	}
	public final void stop() { //stop method는 override 금지 final이 붙었기 때문
		speed = 0;
		System.out.println("멈춤");
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
