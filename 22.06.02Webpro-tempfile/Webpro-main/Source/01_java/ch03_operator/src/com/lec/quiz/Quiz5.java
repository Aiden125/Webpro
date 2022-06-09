package com.lec.quiz;
// (Quiz 5) 국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균(소수점2자리까지) 출력하는 프로그램을 구현 하시오
public class Quiz5 {

	public static void main(String[] args) {
		// 데이터타입 변수명 = 초기값
		int Kor = 80;
		int Eng = 90;
		int Math = 100;
		System.out.println("국어="+Kor + "\t영어=" +Eng + "\t수학="+Math);
		int sum = Kor+Eng+Math;
		System.out.println("합계="+sum);
		double Avg = (Kor+Eng+Math)/3;
		System.out.printf("평균=%.2f", Avg);
		// %c-문자, %d-정수, %f-실수, %s-문자열
		//System.out.printf("i=%d, j=%d, h=%4.2f \n", i, j, h);
	}
}
