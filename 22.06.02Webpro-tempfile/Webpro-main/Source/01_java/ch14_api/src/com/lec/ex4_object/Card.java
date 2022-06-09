package com.lec.ex4_object;
//클로버, 다이아, 스페이드, 하트 모양에 1~13 숫자
public class Card {
	private char kind; // ♣♠◆♥ 클로버, 다이아, 스페이드, 하트
	private int num;

	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드는 " + kind + " , " + num;
	}
	// c1.equals(c2) => c1ㅇ의 kind와 c2의 kind, c1의 num과 c2의 num을 비교
	@Override
	public boolean equals(Object obj) {
		// c1.equals(c2) => c1은 내 객체, c2는 obj.
		if (obj!=null && obj instanceof Card) {// 내 객체의 kind와 obj.kind비교하는 방법
			boolean kindChk = (kind == ((Card) obj).kind); //무늬 비교 Card로 명시적 형변환
			boolean numChk = (num == ((Card)obj).num); //번호 비교 Card로 명시적 형변환
			return kindChk && numChk;  //둘 다 트루면 트루를 리턴하게
		} 
		return false;

	}
}
