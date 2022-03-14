package com.lec.loop;

import java.util.Scanner;

// 구구단 수 입력받아 해당 구구단 출력되는 화면 및 소스파일
public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9 숫자 중 하나를 입력하시오");
		int j = sc.nextInt();
		for(int i=1 ; i<10 ; i++) {
			if(j<1 || j>9) {
				System.out.println("Wrong"); break;
			} else {
			System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
		}
//		int j = sc.nextInt();
//		int tot = i*j;
//		if(i<1 || i>9) {
//			System.out.println("Wrong");
//		} else if(j<1 || j>9) {
//			System.out.println("Wrong");
//		} else {
//		System.out.println(i+"*"+j+"="+tot);
//		}
	}

}
