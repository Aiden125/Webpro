package st3_robot;
// RobotOrder order = new RobotOrder();
// order.action(drawRobot형 객체);
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof SingRobot) { //instanceof = 무슨형인가? 묻는 변수
			((SingRobot) robot).Sing();
		}else if(robot instanceof DanceRobot) { //로봇이 댄스로봇형이냐?
			((DanceRobot) robot).dance();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).Draw();
		}else {
			System.out.println("확장된 로봇이면 이곳에 구현하세요");
		}
	}
}
