package com.lec.ex11robot;
// RobotOrder order = new RobotOrder();
// order.action(drawRobot�� ��ü);
public class RobotOrder {
	public void action(Robot robot) {
		if(robot instanceof SingRobot) { //instanceof = �������ΰ�? ���� ����
			((SingRobot) robot).Sing();
		}else if(robot instanceof DanceRobot) { //�κ��� ���κ����̳�?
			((DanceRobot) robot).dance();
		}else if(robot instanceof DrawRobot) {
			((DrawRobot) robot).Draw();
		}else {
			System.out.println("Ȯ��� �κ��̸� �̰��� �����ϼ���");
		}
	}
}
