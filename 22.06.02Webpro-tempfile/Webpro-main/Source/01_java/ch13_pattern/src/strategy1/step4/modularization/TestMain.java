package strategy1.step4.modularization;

public class TestMain {
	public static void main(String[] args) {
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		Robot[] robots = {superR, standardR, lowR};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		//lowR.setFly(new FlyYes()); 5�ܰ迡���� �� ������ ����ǵ���
		
		
		
//		SuperRobot robot = new SuperRobot();
//		robot.actionFly();
//		robot.setFly(new FlyNO());
//		robot.actionFly();
//		robot.actionKnife();
//		robot.setKnife(new KnifeNo());
//		robot.actionKnife();
	}
}
