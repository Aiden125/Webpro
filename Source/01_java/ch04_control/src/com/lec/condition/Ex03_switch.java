package com.lec.condition;

public class Ex03_switch {

	public static void main(String[] args) {
		int num1 = 2;
		switch(num1) { //정수형 이거나 문자형, 문자열만 가능
			case 1: System.out.println("1입니다");break;
			case 2: System.out.println("2입니다");break;
			case 3: System.out.println("3입니다");break;
			default : System.out.println("그 외 수입니다.");
		}
		
// 		if문으로 하는 경우
//		if (num1==1) {
//			System.out.println("1입니다");
//		}else if(num1==2) {
//			System.out.println("2입니다");
//		}else if(num1==3) {
//			System.out.println("3입니다");
//		}else {
//			System.out.println("그 외 수입니다");
//		}

	}

}
