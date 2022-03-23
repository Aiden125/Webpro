package com.lec.ex05_employee;

public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int computePay() {
		int result = moneyPerHour*hoursWorked;
		return result;
	}

}
