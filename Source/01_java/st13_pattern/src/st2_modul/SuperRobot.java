package st2_modul;

import st2_interfaces.*;

public class SuperRobot extends Robot {
	private IFly fly; 
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		setFly(new FlyYes()); //fly=new FlyYes(); �� �۾��� ���� ����
		setMissile(new MissileYes());  //missile = new MissileYes(); �� �۾��� ���� ����
		setKnife(new KnifeLazer()); //knife = new KnifeLazer();
	}
	
	@Override
	public void actionFly() {
		fly.fly(); //fly�� �ִ°����� ���� fly()�� �����ض�
	}

	@Override
	public void actionMissile() {
		missile.missile(); //missile�� �ִ°����� ���� missile()�� �����϶�
	}

	@Override
	public void actionKnife() {
		knife.Knife(); // knife�� �ִ� ������ ���� knife()�����϶�
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
