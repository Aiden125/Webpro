package com.lec.ex5_momchild;
// child first = new child(첫째	;)
public class Child {
	//데이터
	private String name;
	//클래스데이터
	static MomPouch momPouch;
	
	//생성자(디폴트 생성자)
	public Child() {}
	//생성자(매개변수 1개 짜리 생성자)
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	
	//메소드
	public void takeMoney(int money) {
		if(momPouch.money >= money ) {
			momPouch.money -= money;
			System.out.println(name+"가"+money+"원 가져가서 엄마 지갑에"+momPouch.money+"원 있음");
		}else {
			System.out.println(name+"가 돈을 못받음. 현재 엄마 지갑에는"+momPouch.money+"원 밖에 없음");
		}
	}
}
