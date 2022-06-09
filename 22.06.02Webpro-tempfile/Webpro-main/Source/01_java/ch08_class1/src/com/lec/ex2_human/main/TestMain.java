package com.lec.ex2_human.main;

//com.lec.ex2_human 패키지의 모든 class import
//파일을 다 끝내기 전에 ctrl+shift+o 눌러서 import 필요한 것만 있게하는게 좋음
import com.lec.ex2_human.*;

public class TestMain {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		// 기초데이터 타입에서의 같은지 비교할 때는 ==으로 비교함
		System.out.println(i == j ? "같다" : "다르다");

		// 레퍼런스 변수
		String name = new String("길동이");
		// 원래는 위에처럼 써야하는데 String만 알아서 변환해줌
		String name2 = "길동이";
		// 여기서 다시 정의를 하더라도 원래 기존에 있던 길동이를 가리킴 주소도 동일
		// 그래서 ==이 아닌 equals 함수를 써서 비교해야함
		if (name.equals(name2)) {
			System.out.println("name과 name2와 같다.");
		}

		// 아래 두 아이는 서로 다른 아이(할당되는 주소가 다름)
		// 새로운 객체 타입 정의
		Woman hee1 = new Woman();
		Woman hee2 = new Woman();
		if (hee1.equals(hee2)) { // equals를 넣으면 기본적으로 상속됨
			System.out.println("hee1과 hee2는 같다.");
		}
		Man Kang = new Man(22, 165, 60.3);
		Man Kim = new Man(22, 188, 99.9);
		Man Kim1; // 레퍼런스 변수 선언(객체변수) 선언
		Kim1 = Kim;
		Man Kim2 = new Man(22, 188, 99.9);
		if (Kim.equals(Kim1)) {
			System.out.println("Kim과 Kim1은 같다 즉, 같은 주소값을 가리킨다.");
		}
		// if+equals 쓸 때 느낌표를 이렇게 붙이면 다르다는 형식으로 써짐
		if (!Kim.equals(Kim2)) {
			System.out.println("Kim과 Kim2는 다르다 즉, 다른 주소값을 가리킨다.");
		} else {
			System.out.println("Kim과 Kim2는 같다.");
		}
		Kang.setHeight(160);
		Kang.setWeight(99); // 원래 double로 정의했기에 double로 묵시적인 형변환 됨
		if(Kang.calculateBMI() > 30) {
			System.out.println("건강하세요");
		}else {
			System.out.println("건강하겠네요");
		}

	}

}
