package com.lec.ex01_parentchild;

public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getMamiName();
		child.getPapaName();
		child.getChildName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
		ParentClass p = new ParentClass();
		ParentClass a = new ChildClass();
		a.getMamiName();
		a.getPapaName();
		//ChildClass b = new ParentClass();
	}
}
