package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MissileNo;

public class LowRobot extends Robot {
	public LowRobot() {
		setFly(new FlyNO()); //fly = new FlyNO();
		setMissile(new MissileNo()); //missile = new MissileNo();
		setKnife(new KnifeNo()); //knife = new KnifeNo();
	}
}
