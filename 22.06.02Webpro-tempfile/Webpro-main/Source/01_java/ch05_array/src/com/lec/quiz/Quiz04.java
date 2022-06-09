package com.lec.quiz;
// 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?
// 
public class Quiz04 {
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
