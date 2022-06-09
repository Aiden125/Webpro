package com.lec.ex5_homework;

public class Member {
	private String name;
	private String tel;
	private String birth;
	private String address;
	
	public Member() {
	}
	
	public Member(String name, String tel, String birth, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}

	@Override
	public String toString() {
		return name + " " + tel + " " + birth + "»ý " + address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}	
	
}
