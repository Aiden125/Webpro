package com.lec.ex3_math;
// Math.ceil(올릴 실수값) => double값 return
// Math.round(반올림할 실수값) => int값 return
// Math.floor(내릴 실수값) => double값 return
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림 : "+Math.ceil(9.15)); //ceil의 return타입은 double
		System.out.println("9.15를 올림 : "+(int)Math.ceil(9.15)); //형변환 원한다면 명시적 형변환 활용
		System.out.println("9.15를 반올림 "+Math.round(9.15));
		System.out.println("9.15를 반올림 "+Math.floor(9.15));
		System.out.println("소수점 두 번째자리에서 반올림, 올림, 버림"); // 자바에는 별도로 한번에 계산하는게 없기에 잔머리를 굴려야함
		System.out.println("9.15를 올림 : "+Math.ceil(9.15 * 10)/10); //9.15를 둘째자리에서 반올림하기위해서 *10을 했다가 계산 후 다시 10으로 나눔
		System.out.println("9.15를 반올림 : "+Math.round(9.15*10)/10.0); //위와 같은 방법이나, double로 return해주기 위해서 10.0으로 나눔
		System.out.println("9.15를 내림 : "+Math.floor(9.15*10)/10.0); //동일하게 double형식 유지
		
		System.out.println("일의 자리에서 반올림, 올림, 내림");
		System.out.println("85를 올림 : "+(int)Math.ceil(85/10.0)*10); //90.0의 형태로 원하면 int지우면 됨
		System.out.println("85를 반올림 : "+Math.round(85/10.0)*10);
		System.out.println("85를 내림 : "+(int)Math.floor(85/10.0)*10); //80.0의 형태로 원하면 int지우면 됨
		
	}
}
