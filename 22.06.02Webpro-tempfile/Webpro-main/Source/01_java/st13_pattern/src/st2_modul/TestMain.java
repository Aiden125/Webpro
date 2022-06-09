package st2_modul;

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
		//lowR.setFly(new FlyYes()); 5단계에서는 이 문장이 실행되도록
		
		
		
//		SuperRobot robot = new SuperRobot();
//		robot.actionFly();
//		robot.setFly(new FlyNO());
//		robot.actionFly();
//		robot.actionKnife();
//		robot.setKnife(new KnifeNo());
//		robot.actionKnife();
	}
}
