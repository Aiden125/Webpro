package com.lec.loop;
// break : 블럭을 완전히 빠져 나감
// continue : 블럭의 실행을 멈추고 증감부분으로 이동
public class Ex05_breakContinue {
	public static void main(String[] args) {
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) {
				continue; // continue는 실행 안하고 바로 증감으로 감(3빼고 출력(점프))
				// break는 반복문 블럭을 빠져 나가 3이 되면 멈춰서 0,1,2만 출력
			}
			System.out.println(i+". 안녕");
		}
	}
}
