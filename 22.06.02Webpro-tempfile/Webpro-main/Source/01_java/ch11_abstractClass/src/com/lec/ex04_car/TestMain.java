package com.lec.ex04_car;

import com.lec.cons.CarSpec;

public class TestMain {
	public static void main(String[] args) {
//		Car ar = new LowGradeCar("ȸ��", "�Ϲ�", 1000, "�Ŀ�");
//		Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NORMAL, CarSpec.DISPLACEMENT_1000, CarSpec.HANDLE_POWER);
//		car.getSpec();
		
		//���� �䱸������ �ٲ� ���ο� HighGrade�� ���� ������ ���
		//���� ������ �ڵ带 �����ؼ� ���� ����.
		Car car = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2200, CarSpec.HANDLE_POWER);
		car.getSpec();
	}
}
