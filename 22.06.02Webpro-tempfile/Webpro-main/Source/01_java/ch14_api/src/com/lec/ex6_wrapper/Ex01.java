package com.lec.ex6_wrapper;

//equals 즉, 같은지 비교를 하려면 객체vs객체로 비교를 해야되는데 기초데이터 타입의 경우
//비교가 안되기에 자바에서 자동적으로 Integer값을 생성해주나 직접정의 하는 방법도 존재
public class Ex01 {
	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("합은 "+sum);
		System.out.println(i==j ? "두 int는 같다" : "두 int는 다르다");
		Double iObj = 10.1; // 아래와 정확히 같은 값. 문제도 x
		Double jObj = new Double(10.1);
		sum = iObj + jObj; //간단하게는 이렇게 해도 되며, 자세하게 보면 아래 값으로 자동적으로 변환 해주는 것이나 마찬가지
		// sum = iObj.intValue() + jObj.intValue(); //객체.Intvalute = 그 안에 있는 정수 값을 가져오는 함수
		System.out.println("합은 "+sum);
		System.out.println(iObj.equals(j) ? "두 wrapper객체 값은 같다" : "두 wrapper객체 값은 다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");
		
	}
}
