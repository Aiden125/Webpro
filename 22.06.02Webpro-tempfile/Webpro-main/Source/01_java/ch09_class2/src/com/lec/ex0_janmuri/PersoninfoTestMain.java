package com.lec.ex0_janmuri;
//한 클래스안에 클래스가 두 개 있는 경우
class PersonInfo{
	private String name;
	private int age;
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print()	{
		System.out.printf("이름=%s / 나이=%d\n", name, age);
	}
}
public class PersoninfoTestMain {
	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("홍길동", 22), new PersonInfo("신길동", 33)};
		//확장 for문
		for(PersonInfo p : person) {
			p.print();
		}
		//일반 for문
		for(int idx=0; idx<person.length ; idx++) {
			person[idx].print();
		}
	}
}
