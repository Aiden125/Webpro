package strategy2.modularizition;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDiesel;
import strategy2.interfaces.Km10;

public class Accent extends Car {
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km10());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("�׼�Ʈ ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");

	}

}
