package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes()); //fly=new FlyYes(); 이 작업과 같은 내용
		setMissile(new MissileYes());  //missile = new MissileYes(); 이 작업과 같은 내용
		setKnife(new KnifeLazer()); //knife = new KnifeLazer();
	}
}
