package com.st05_array;

public class Ex02_array_quiz {
	public static void main(String[] args) {
		int coin[] = {500, 100, 50, 10};
		int money = 2680;
		for(int index=0 ; index<coin.length ; index++) {
			System.out.println(coin[index]+"원 짜리"+money/coin[index]+"개");
			money %= coin[index];
		}
//		for(int coin : coinUnit) {
//			System.out.println(coin+"원짜리 동전"+(money/coin)+"개");
////			money %= coin;
//		}
	}
}

