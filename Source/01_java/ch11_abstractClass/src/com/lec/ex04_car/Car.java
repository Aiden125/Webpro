/*
 * �ڵ��� �ɼǿ� ���� ����Ǵ� ���� ��� ���α׷��� ���� �ؽó����� �μ� �� ����� ���� �ڵ��� ��ü�� ������. �ڵ����� ��� ������
 * �ڵ��� �𵨿��� �ɼ� ���׿� ���� ���� ���̰� �ֽ��ϴ�. �� �� ��ⷮ�� ���� �ڵ����� ��� ������ �����ϴ�. Car : color,
 * tire, displacement, handle, getSpec() LowGradeCar : tax, color(���),
 * tire(�Ϲ�Ÿ�̾�), displacement(2000), handle(�Ŀ��ڵ�), getSpec() HighGradeCar : tax,
 * color(����), tire(����Ÿ�̾�), displacement(2200), handle(�Ŀ��ڵ�), getSpec() ��
 * getSpec()�� ���ؼ� �ڵ����� �ɼ��� ����, ������ �ľ��մϴ�
 * color, tire, displacement, handle, getSpec(�߻�޼ҵ�)
 */
package com.lec.ex04_car;

public abstract class Car {
	private String color;
	private String tire; //Ÿ�̾�
	private int displacement; //��ⷮ
	private String handle; //�ڵ�
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
