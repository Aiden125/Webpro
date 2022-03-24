package com.lec.ex;
/*
println() ; 콘솔창에 출력(개행포함)
print() ; 콘솔창에 출력(개행 미포함)
printf() ; 콘솔창에 특정한 포맷으로 출력(개행미포함)
 */
public class VarEx02 {
	public static void main(String[] args) {
		// 데이터타입 변수명 = 초기값
		int i = 10; // 4byteW짜리 j라는 메모리공간에 10을 핟당
		byte j = 10; // 2byte짜리 j라는 메모리공간에 10을 할당
		double h = 10.15;
		i = 5;
		System.out.println("i="+i+"\t j="+j+"\t h="+h);
		char c1 = 'A' ;
		char c2 = 'B' ;
		System.out.print("c1="+c1+"\t c2="+c2+"\n"); // "\n" : 개행
		System.out.printf("c1=%c \t c2=%c2\n", c1, c2);
		// %c-문자, %d-정수, %f-실수, %s-문자열
		System.out.printf("i=%d, j=%d, h=%4.2f \n", i, j, h);
		System.out.println("끝");
	}
}
