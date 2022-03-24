package strategy1.step4.modularization;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.KnifeNo;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot robot = new SuperRobot();
		robot.actionFly();
		robot.setFly(new FlyNO());
		robot.actionFly();
		robot.actionKnife();
		robot.setKnife(new KnifeNo());
		robot.actionKnife();
	}
}
