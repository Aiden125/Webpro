package st2_modul;

import st2_interfaces.FlyNO;
import st2_interfaces.IFly;
import st2_interfaces.IKnife;
import st2_interfaces.IMissile;
import st2_interfaces.KnifeNo;
import st2_interfaces.MissileNo;

public class LowRobot extends Robot {
	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public LowRobot() {
		setFly(new FlyNO()); //fly = new FlyNO();
		setMissile(new MissileNo()); //missile = new MissileNo();
		setKnife(new KnifeNo()); //knife = new KnifeNo();
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
