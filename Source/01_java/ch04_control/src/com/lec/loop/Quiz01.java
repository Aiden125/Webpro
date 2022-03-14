package com.lec.loop;
//1~10까지 곱을 구해보자(누적곱의 변수에 1로 초기화)
public class Quiz01 {
	public static void main(String[] args) {
		int tot = 1; //누적할 변수
		for(int i=2 ; i<=10 ; i++) {
			tot = (tot*i);// tot = tot * i;
		}
		System.out.println("1~10까지 누적곱은 "+tot);
	}
}
