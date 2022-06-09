package com.lec.ex2_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_greagorinCal2 {
	public static void main(String[] args) {
		//util에 있는 date import
		//가운데 줄 가있는 이유는 조만간 사라질 수 있다는 의미(안쓰는거 권장)
		Date date = new Date();
		System.out.println(date); // 가독성 bad
		int year = date.getYear() + 1900; // "연도"
		int month = date.getMonth() + 1; // "월"
		int day = date.getDate(); // 일
		System.out.printf("%d년 %d월 %d일\n", year, month, day);
		
		// %d(정수) %f(실수) %s(문자열) %c(문자)
		// %tY(년) %tm(월) %td(일) %ta(요일) %tH(24시) %tp(오전/오후) %tl(12시) %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분  %tS초\n", date, date, date, date, date, date, date, date);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS초\n", date);
	}
}
