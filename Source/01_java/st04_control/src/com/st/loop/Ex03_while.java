package com.st.loop;

public class Ex03_while {
	public static void main(String[] args) {
		int i=10;
		while(i>=1) {
			System.out.println(i+". ");
			--i;
		}
		
		// for문으로 하는 경우
//		for(int i=10 ; i>=1 ; i--) {
//			System.out.print(i+".");
		}
	}
