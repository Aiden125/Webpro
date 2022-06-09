package com.lec.ex09_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person();
		papa.setName("¾Æºü"); papa.setCharacter("¶×¶×ÇØ");
		papa.intro();
		System.out.println("----------------------------");
		Person mom = new Person("¾ö¸¶","³¯¾ÀÇØ");
		mom.intro();
		System.out.println("----------------------------");
		Baby child1 = new Baby();
		child1.setName("¾Ö±â");
		child1.setCharacter("±Í¿©¿ö");
		child1.intro();
		System.out.println("----------------------------");
		Baby child2 = new Baby("¾Æ±â2", "³Ê¹«±Í¿©¿ö");
		child2.intro();
	}
}
