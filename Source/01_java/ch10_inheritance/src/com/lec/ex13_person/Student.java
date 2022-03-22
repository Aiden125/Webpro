package com.lec.ex13_person;

public class Student extends Person {
	private static int count = 0;
	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++count;
		setNo("st10"+count);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf("(¹Ý)%s\n", ban);
	}
	
}
