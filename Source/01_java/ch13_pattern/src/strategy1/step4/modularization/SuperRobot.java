package strategy1.step4.modularization;

import strategy1.step4.interfaces.*;

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
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.Knife();
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
