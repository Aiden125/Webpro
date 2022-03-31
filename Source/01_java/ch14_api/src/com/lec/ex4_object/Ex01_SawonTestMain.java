package com.lec.ex4_object;
// 만약 부서에 대한 기록을 개인마다 다르게 한다면? 전산, 전산실, 컴퓨터 등등 각각 다르게 쓸 수 있기에 이를 방지해야한다. -약속된 String을 구현해보자
//Sawon s1 = new Sawon("a01", "홍길동", "Dept.COMPUTER") - 오늘 입사일 (static이 들어간 경우 클래스명.컴퓨터 이런식으로 써야함 예시는 앞에 있는 Dept.COMPUTER)
//Sawon s2 = new Sawon("a02", "아이유", "Dept.HUMANRECOURCES", 2022.3.24) - 3월 24일 입사일
//System.out.prtinln(s1) => [사번]a01 [이름]홍길동 [부서]COMPUTER [입사일]2022년3월24일(목)
public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER);
		Sawon s2 = new Sawon("a02", "아이유", Dept.HUMANRESOURCES, 2022,3,24);
		//Tostring override도 고려해서 프린트
		//0. Tostring 오버라이드 1. SimpleDateFormat api, 2.String 함수(length())이용
		System.out.println(s1); 
		System.out.println(s2);
		Sawon2 s3 = new Sawon2("c01", "마길수", Dept2.PLANNING, 2022, 3, 10);
		System.out.println(s3);
	}
}
