package com.lec.ex4.quiz;

public class Member {
	private String name;
	private String number;
	private String address;
	
	public Member(String name, String number, String address) {
		this.name = name;
		this.number = number;
		this.address = address;
	}
	@Override
	public String toString() {
		return "[이름]"+name + " [번호]"+number + " [주소]"+address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
