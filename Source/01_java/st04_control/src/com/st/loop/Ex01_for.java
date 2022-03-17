package com.st.loop;
//1~40까지 한줄에 4개씩 출력
public class Ex01_for {
	public static void main(String[] args) {
		for(int i=1 ; i<=40 ; i++) {
			System.out.print(i+"\t");
			if(i%4==0) {
				System.out.println(); // i가 4의 배수이면 개행 추가
			}
		}
	}
}
