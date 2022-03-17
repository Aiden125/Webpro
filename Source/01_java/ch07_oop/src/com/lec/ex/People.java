package com.lec.ex;

public class People {
	private int weight;
	private int age;
	
	public int ap() {
		return age*weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public int getAge() {
		return age;
	}
}
