package com.lec.ch02.ex1_cal;

import lombok.Data;

@Data
public class MyCalculator {
	private Calculator calculator;
	private int n1;
	private int n2;
	
	public void add() {
		calculator.addition(n1, n2);
	}
	
	public void sub() {
		calculator.substraction(n1, n2);
	}
	
	public void mul() {
		calculator.multiplication(n1, n2);
	}
	
	public void div() {
		calculator.division(n1, n2);
	}
}
