package com.lec.ex13_person;

public class Staff extends Person {
	private static int count = 0;
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++count;
		setNo("staff"+count);
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("(����)%s\n", department);
	}

}
