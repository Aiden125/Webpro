package com.lec.ex09_super;
// name, character / intro()
// Baby b = new Baby("홍아가", "이뻐");
// Baby b1 = new Baby();
// this든 super든 해당 method의 가장 첫 번째 줄에 기재할 것
public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		super(name, character); //부모단의 매개변수 2개 짜리 생성자로 수행됨
//		setName(name); setCharacter(character);
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.println("응애 응애 난 아가야");
		super.intro(); // 내 클래스의 부모단의 intro() 함수
	}
}
