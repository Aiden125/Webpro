package ex6;
//CheckingAccount a2 = new CheckingAccount("11-11", "홍길동", 2000, "1111-2222-3333-4444")
public class CheckingAccount extends Account {
	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.println(ownerName+"님 계좌 개설시에는 10원 이상 금액이 필요합니다.");
	}
	
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.println(ownerName+"님 "+balance+"원으로 계좌 개설 되었습니다.");
	}
	
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) {
			if(getBalance() >= amount) {
				setBalance(getBalance()-amount);
				System.out.println(amount+"원 결제하여 남은 금액 : "+getBalance());
			}else {
				System.out.println("잔액이 부족합니다.");
			}
		}
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
