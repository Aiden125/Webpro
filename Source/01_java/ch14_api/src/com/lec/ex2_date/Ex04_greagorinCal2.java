package com.lec.ex2_date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex04_greagorinCal2 {
	public static void main(String[] args) {
		//util�� �ִ� date import
		//��� �� ���ִ� ������ ������ ����� �� �ִٴ� �ǹ�(�Ⱦ��°� ����)
		Date date = new Date();
		System.out.println(date); // ������ bad
		int year = date.getYear() + 1900; // "����"
		int month = date.getMonth() + 1; // "��"
		int day = date.getDate(); // ��
		System.out.printf("%d�� %d�� %d��\n", year, month, day);
		
		// %d(����) %f(�Ǽ�) %s(���ڿ�) %c(����)
		// %tY(��) %tm(��) %td(��) %ta(����) %tH(24��) %tp(����/����) %tl(12��) %tM(��) %tS(��)
		System.out.printf("%tY�� %tm�� %td�� %ta���� %tp %tl�� %tM��  %tS��\n", date, date, date, date, date, date, date, date);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$ta���� %1$tp %1$tl�� %1$tM�� %1$tS��\n", date);
	}
}
