package com.lec.ex6_wrapper;

import com.lec.ex4_object.Dept;
import com.lec.ex4_object.Sawon;
//equals 즉, 같은지 비교를 하려면 객체vs객체로 비교를 해야되는데 기초데이터 타입의 경우
//비교가 안되기에 자바에서 자동적으로 Integer값을 생성해주나 직접정의 하는 방법도 존재
public class Ex02 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("합은 "+sum);
		System.out.println(i==j ? "두 int는 같다" : "두 int는 다르다");
		Integer iObj = new Integer(10); // Integer iObj = 10 이렇게 넣어도 10이라는 값을 가리키는 주소를 가진 객체 생성 자동으로 해줌
		Integer jObj = new Integer(10);
		sum = iObj + jObj; //간단하게는 이렇게 해도 되며, 자세하게 보면 아래 값으로 자동적으로 변환 해주는 것이나 마찬가지
		// sum = iObj.intValue() + jObj.intValue(); //객체.Intvalute = 그 안에 있는 정수 값을 가져오는 함수
		System.out.println("합은 "+sum);
		System.out.println(iObj.equals(jObj) ? "두 wrapper객체 값은 같다" : "두 wrapper객체 값은 다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");
		
		
		Sawon s =new Sawon("a01", "홍길동", Dept.COMPUTER);
		//equals를 쓸 때는 주소값을 가리키는 "객체"가 들어가야 하기에 i를 넣으려고 하면 못 넣음. i는 기초데이터 변수기 때문에 그냥 특정 값을 가지는 중
		// if(s.equals(obj))
	}
}
