/*
 * 자동차 옵션에 따라 변경되는 세금 계산 프로그래밍 구현 ※시나리오 부석 후 상속을 통해 자동차 객체를 만들어본다. 자동차의 경우 동일한
 * 자동차 모델에서 옵션 사항에 따라 세금 차이가 있습니다. 그 중 배기량이 높은 자동차의 경우 세금이 높습니다. Car : color,
 * tire, displacement, handle, getSpec() LowGradeCar : tax, color(블루),
 * tire(일반타이어), displacement(2000), handle(파워핸들), getSpec() HighGradeCar : tax,
 * color(레드), tire(광폭타이어), displacement(2200), handle(파워핸들), getSpec() ☞
 * getSpec()을 통해서 자동차의 옵션을 보고, 세금을 파악합니다
 * color, tire, displacement, handle, getSpec(추상메소드)
 */
package com.lec.ex04_car;

public abstract class Car {
	private String color;
	private String tire; //타이어
	private int displacement; //배기량
	private String handle; //핸들
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	public abstract void getSpec();
	
	// setter & getter
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTire() {
		return tire;
	}
	public void setTire(String tire) {
		this.tire = tire;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
}
