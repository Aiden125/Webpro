package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public StandardRobot() {
		setFly(new FlyNO()); // fly = new FlyNo();
		setMissile(new MissileYes()); //missile = new MissileYes
		setKnife(new KnifeWood()); //knife = new knifeWood();
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
