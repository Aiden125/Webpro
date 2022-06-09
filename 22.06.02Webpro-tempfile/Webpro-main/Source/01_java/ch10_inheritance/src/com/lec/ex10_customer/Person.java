package com.lec.ex10_customer;
public class Person {
	private String name;
	private String tel; // Person p = new Person("홍", "010-2222-3333")
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String infoString() { //sysout(p.infoString()) 만약, sysout(p)로만 하고 싶다면 toString 오버라이딩 해야함
		return "[이름]"+name+" [전화]" + tel;
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
}
