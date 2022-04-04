package com.lec.ex3_set;

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
		return name + number + address;
	}
	
}
