package com.lec.ex05_employee;

public abstract class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;		
	}
	
	public abstract int computePay();
	
	//만약 밑에 인센티브에 스태틱을 넣으면 computePay를 못가져옴
	public final int computeIncentive() {
		int result = computePay();
		if(result >= 2000000) {
			result = (int)(result*0.1);
			}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}
