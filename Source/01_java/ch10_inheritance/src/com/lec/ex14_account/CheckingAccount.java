package com.lec.ex14_account;
// CheckingAccount a2 = new CheckingAccount("11-11", "홍길동", 2000, "1111-2222-3333-4444")
public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)님 계좌 개설 희망 시 입금액이 필요합니다.\n", ownerName, accountNo);
		// balance = 0; 으로 원래 초기화 되어있음
	}
	public CheckingAccount(String accountNo, String ownerName,long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)님 %d원 계좌 개설되었습니다\n", ownerName, accountNo, balance);
		// balance = 0; 으로 원래 초기화 되어있음
	}
	// a2.pay("1111-1111-2222-3333",1000);
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { //String의 경우 비교는 a.equals(b) 이런식으로 해야.
			if(getBalance() >= amount) { //함수는 꼭 괄호. 지불가능한지
				setBalance(getBalance() - amount); //balance -= amount;
				System.out.printf("%s(%s)님 %d원 지불하여 잔액 %d원 남았습니다\n", getOwnerName(), getAccountNo(), amount, getBalance());
			}else {
				System.out.printf("%s(%s)님 잔액%d원으로 %d원 지불 불가합니다.\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		}else {
			System.out.println("올바른 카드번호를 입력하세요");
		}//if
	}//pay
	public String getCardNo() {
		return cardNo;
	}
	
}//class
