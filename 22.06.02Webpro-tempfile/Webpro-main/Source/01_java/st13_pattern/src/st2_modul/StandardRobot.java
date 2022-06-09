package st2_modul;

import st2_interfaces.FlyNO;
import st2_interfaces.IFly;
import st2_interfaces.IKnife;
import st2_interfaces.IMissile;
import st2_interfaces.KnifeWood;
import st2_interfaces.MissileYes;

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
