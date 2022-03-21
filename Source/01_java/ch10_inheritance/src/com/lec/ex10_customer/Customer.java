package com.lec.ex10_customer;
// name, tel, address, sum, point, date, vip
// Customer c = new Customer("홍", "010-22-33", "서울 노원구 어디","1992-12-12");
public class Customer extends Person {
	private String address;
	private int sum; // 구매 누적 금액
	private int point; // 포인트(구매마다 5%적립)
	private String date; // 기념일(아직 date 사용x)
	private boolean vip; // true면 vip, false면 일반
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000; // 새 고객에게는 1000p 자동 지급
		System.out.println(name+"님 감사합니다. 가입 기념으로 포인트 1000점을 선물로 드립니다.");
	}
	public void buy(int price) {// c.buy(10000)
		sum += price;
		int tempPoint = (int)(price*0.05);
		point += tempPoint;
		System.out.println(getName()+"님 감사합니다. 이번 포인트 : "+tempPoint+"점 추가되어 누적 포인트 : "+point);
		if(sum>=1000000 && vip==false) {
			vip = true; // 구매 누적 금액이 100만원 이상 시 vip고객으로 지정
			System.out.println(getName() + "님 VIP고객으로 업그레이드 되셨습니다.");
		}// if
	}// buy
	// 1번 c.print() or 2번 sysout(c.infoString()) or 3번 sysout(c)
	// sysout(c.infoString()) / super.infoString() "[이름]홍[전화]010-2222-22"
	@Override // @ : 어노테이션. 문법이 올바른지 체크해줌
	public String infoString() {
		return super.infoString() +" [주소]"+address+" [포인트]"+point+" [누적금액]"+sum;
	}
}
