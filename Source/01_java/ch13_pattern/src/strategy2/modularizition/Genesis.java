package strategy2.modularizition;

import strategy2.interfaces.EngineHigh;
import strategy2.interfaces.FuelGasoline;
import strategy2.interfaces.Km10;

//상속 받은 멤법 : 3가지 부품 변수 / drive(일반), shape(추상), engine(일반), km(일반), fuel(일반) / setter
public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngineHigh()); // engine = new EngineHigh(); 이게 편하긴 한데 engine이 내꺼가 아니라 car꺼여서 set으로
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	@Override
	public void shape() {
		System.out.println("제네시스 모양은 door, sheet, handel로 이루어져 있습니다.");
	}

}
