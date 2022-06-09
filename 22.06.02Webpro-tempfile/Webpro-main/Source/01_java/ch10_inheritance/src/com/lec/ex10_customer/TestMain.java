package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("ȫ", "010-1122-3344", "�����", "1992-01-02");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		
		Person staff = new Staff("�����", "010-2211-2223", "2022-08-21", "������");
		Person person = new Person("��", "010-2223-1312");
		Person[] personArr = {customer, staff, person};
		
		System.out.println("�Ϲ�for��");
		for(int i=0 ; i<personArr.length ; i++) {
			System.out.println(personArr[i].infoString());
		}
		
		System.out.println("Ȯ��for��");
		//�迭 0~������� infoString()
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		// Array 0~������� buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) { //p������ Customer�� ��ü�ΰ�?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy�� Customer�� �����մϴ�");
			} //if
		} //for
	} //main
} //class
