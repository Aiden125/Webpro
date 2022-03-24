package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍", "010-1122-3344", "노원구", "1992-01-02");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		
		Person staff = new Staff("김수달", "010-2211-2223", "2022-08-21", "개발팀");
		Person person = new Person("이", "010-2223-1312");
		Person[] personArr = {customer, staff, person};
		
		System.out.println("일반for문");
		for(int i=0 ; i<personArr.length ; i++) {
			System.out.println(personArr[i].infoString());
		}
		
		System.out.println("확장for문");
		//배열 0~끝방까지 infoString()
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		// Array 0~끝방까지 buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) { //p변수가 Customer형 객체인가?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy는 Customer만 가능합니다");
			} //if
		} //for
	} //main
} //class
