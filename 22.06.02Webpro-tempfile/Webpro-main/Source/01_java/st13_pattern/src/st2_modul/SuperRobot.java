package st2_modul;

import st2_interfaces.*;

public class SuperRobot extends Robot {
	private IFly fly; 
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		setFly(new FlyYes()); //fly=new FlyYes(); 이 작업과 같은 내용
		setMissile(new MissileYes());  //missile = new MissileYes(); 이 작업과 같은 내용
		setKnife(new KnifeLazer()); //knife = new KnifeLazer();
	}
	
	@Override
	public void actionFly() {
		fly.fly(); //fly가 있는곳으로 가서 fly()를 실행해라
	}

	@Override
	public void actionMissile() {
		missile.missile(); //missile이 있는곳으로 가서 missile()을 실행하라
	}

	@Override
	public void actionKnife() {
		knife.Knife(); // knife가 있는 곳으로 가서 knife()실행하라
	}
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}
