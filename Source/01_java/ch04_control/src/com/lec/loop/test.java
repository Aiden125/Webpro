package com.lec.loop;

import java.util.Scanner;

// ������ �� �Է¹޾� �ش� ������ ��µǴ� ȭ�� �� �ҽ�����
public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~9 ���� ���� �� �� ������ ������ �Է��Ͻÿ�");
		int i = sc.nextInt();
		int j = sc.nextInt();
		int tot = i*j;
		if(i<1 || i>9) {
			System.out.println("Wrong");
		} else if(j<1 || j>9) {
			System.out.println("Wrong");
		} else {
		System.out.println(i+"*"+j+"="+tot);
		}
	}

}
