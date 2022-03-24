package com.lec.ex04_actor;

public class TestMain {
	public static void main(String[] args) {
		
		//Actor라는 큰 꾸러미에서 actor 타입으로 적용되기에 다 가능
		Actor park = new Actor("배우 박보검");
		park.canCatchCriminal();
		park.outFire();
		park.makeSpaghetti();
		park.canSearch();
		
		//Actor라는 큰 꾸러미에서 쉐프 타입으로 적용되기에 요리만 가능
		IChef IU = new Actor("요리사 아이유");
		IU.makePizza();
		IU.makeSpaghetti();
		
		//Actor라는 큰 꾸러미에서 소방관 타입으로 적용됨
		IFireFighter kim = new Actor("소방관 김수로");
		kim.outFire();
		kim.saveMan();
		
		IPoliceMan policepark = new Actor("경찰 박보검버섯");
		policepark.canCatchCriminal();
		policepark.canSearch();
	}
}
