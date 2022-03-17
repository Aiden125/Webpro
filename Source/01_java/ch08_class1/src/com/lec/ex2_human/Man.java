package com.lec.ex2_human;
// Man Kin = new Man(22, 160, 50.3, "010-2222-2222");
// Man Kin = new Man(22, 160, 50.3);
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	
	//디폴트 생성자 함수 
	public Man() {} 
	//매개변수 한개짜리 생성자 함수
	public Man(int age) {
		this.age = age;
	}
	
	//전화번호를 뺀 3개짜리 생성자 함수
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("파라미터가 3개짜리 생성자 함수 호출");
	}
	//전화번호를 포함한 4개짜리 생성자 함수
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("파라미터가 4개짜리 생성자 함수 호출");
	}
	public double calculateBMI() {
		double result = weight / ((height/100.0) * (height/100.0));
		return result;
	}
	// setter & getter(age, height, weight, phoneNum) m.getAge() m .setAge()
	
	// setter
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	//getter
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
}