package com.st.loop;

public class Ex05_breakContinue {
	public static void main(String[] args) {
		for(int i=0 ; i<=5 ; i++) {
			if(i==3) {
				continue; // continue�� ���� ���ϰ� �ٷ� �������� ��(3���� ���(����))
				// break�� �ݺ��� ���� ���� ���� 3�� �Ǹ� ���缭 0,1,2�� ���
			}
			System.out.println(i+". �ȳ�");
		}
	}
}

