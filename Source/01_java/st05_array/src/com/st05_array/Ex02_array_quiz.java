package com.st05_array;

public class Ex02_array_quiz {
	public static void main(String[] args) {
		int coin[] = {500, 100, 50, 10};
		int money = 2680;
		for(int index=0 ; index<coin.length ; index++) {
			System.out.println(coin[index]+"�� ¥��"+money/coin[index]+"��");
			money %= coin[index];
		}
//		for(int coin : coinUnit) {
//			System.out.println(coin+"��¥�� ����"+(money/coin)+"��");
////			money %= coin;
//		}
	}
}

