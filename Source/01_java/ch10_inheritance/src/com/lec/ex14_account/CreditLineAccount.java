package com.lec.ex14_account;
// CreditLineAccount c2 = new CreditLineAccount("11-11", "홍", "1111-2222-3333-4444", 10000)
// CreditLineAccount c2 = new CreditLineAccount("11-11", "홍", 1000, "1111-2222-3333-4444", 10000)
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // 카드 한도
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { //String의 경우 비교는 a.equals(b) 이런식으로 해야.
			if(creditLine >= amount) { //함수는 꼭 괄호. 지불가능한지
				creditLine -= amount;
				System.out.printf("%s(%s)님 %d원 지불하여 한도 %d원 남았습니다\n", getOwnerName(), getAccountNo(), amount, creditLine);
			}else {
				System.out.printf("%s(%s)님 잔여 한도 %d원으로 %d원 결제 불가합니다.\n", getOwnerName(), getAccountNo(), creditLine, amount);
			}
		}else {
			System.out.println("올바른 카드번호를 입력하세요");
		}
	}
}
