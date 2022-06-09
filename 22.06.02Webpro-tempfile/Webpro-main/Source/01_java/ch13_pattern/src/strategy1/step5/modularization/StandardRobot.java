package strategy1.step5.modularization;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.IFly;
import strategy1.step4.interfaces.IKnife;
import strategy1.step4.interfaces.IMissile;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

public class StandardRobot extends Robot {
	public StandardRobot() {
		setFly(new FlyNO()); // fly = new FlyNo();
		setMissile(new MissileYes()); //missile = new MissileYes
		setKnife(new KnifeWood()); //knife = new knifeWood();
	}
}
