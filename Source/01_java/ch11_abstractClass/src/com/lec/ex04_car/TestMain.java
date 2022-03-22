package com.lec.ex04_car;

import com.lec.cons.CarSpec;

public class TestMain {
	public static void main(String[] args) {
//		Car ar = new LowGradeCar("회색", "일반", 1000, "파워");
//		Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NORMAL, CarSpec.DISPLACEMENT_1000, CarSpec.HANDLE_POWER);
//		car.getSpec();
		
		//고객의 요구사항이 바뀌어서 새로운 HighGrade를 만들어서 적용한 경우
		//절대 기존의 코드를 수정해서 하지 않음.
		Car car = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2200, CarSpec.HANDLE_POWER);
		car.getSpec();
	}
}
