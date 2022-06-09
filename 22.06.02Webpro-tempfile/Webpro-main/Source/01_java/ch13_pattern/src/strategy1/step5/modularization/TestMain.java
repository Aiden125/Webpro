package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

// 5단계 : 기능을 부품화 -> 유지보수를 간편하게
public class TestMain {
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot robot : robots) {
//			robot.shape();
//			robot.actionWalk();
//			robot.actionRun();
//			robot.actionFly();
//			robot.actionMissile();
//			robot.actionKnife();
//		}
		//SuperRobot 업그레이드 요청 : 날 수 있습니다 => 높이 고공비행합니다
		//고공비행하는 부품 만들어 setFly만 호출
		superR.setFly(new FlyHigh()); //업그레이드완성
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
//		SuperRobot robot = new SuperRobot();
//		robot.actionFly();
//		robot.setFly(new FlyNO());
//		robot.actionFly();
//		robot.actionKnife();
//		robot.setKnife(new KnifeNo());
//		robot.actionKnife();
	}
}
