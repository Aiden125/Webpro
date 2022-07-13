package com.lec.ch03.ex1;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	private ArrayList<String> hobby;
	private double height;
	private double weight;
	
	// lombok API는 매개변수가 없거나 다 있거나 둘 중 하나기 때문에 별도로 만든 것
	public Student(String name, int age, ArrayList<String> hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}
	
	
}
