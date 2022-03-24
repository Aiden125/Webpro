package com.st05_array;
// 2680원을 500원 100원 50원 10원 짜리로 각각 나오는 자판기 출력
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

