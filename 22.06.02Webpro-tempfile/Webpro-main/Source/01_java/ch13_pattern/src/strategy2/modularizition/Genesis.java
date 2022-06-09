package strategy2.modularizition;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//��� ���� ��� : 3���� ��ǰ ���� / drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�), fuel(�Ϲ�) / setter
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh()); // engine = new EngineHigh(); �̰� ���ϱ� �ѵ� engine�� ������ �ƴ϶� car������ set����
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("���׽ý� ����� door, sheet, handel�� �̷���� �ֽ��ϴ�.");
	}

}
