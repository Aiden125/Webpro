package st08_ex2_account;
/*
은행계좌(Account) 클래스 설계
데이터(속성) : 계좌번호(accountNo:String), 예금주(ownerName:String), 잔액(balance:long)
기능(메소드) : 예금하다(void deposit(int)), 인출하다(int withdraw(int)), 잔액조회(long getBalance())
Account a = new Account("100-1", "홍길동"); / Account("100-2", "신길동", 222000)
*/
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;

	// 생성자 함수(껍데기 만들기) 3가지 만들기 -> 데이터(인스턴스, 파라미터) 초기화가 only goal
	// return 타입이 없어야하고 public이어야하고, class이름과 같아야함
	public Account() { // 디폴트 생성자
	} 

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		// balance = 0; 이건 안해도 됨(기본적으로 객체 설정시 0값으로 초기화)
		System.out.printf("%s(%s)님 계좌 개설 희망 시 입금액이 필요합니다.\n", ownerName, accountNo);
	}

	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		// balance = 0; 이건 안해도 됨(기본적으로 객체 설정시 0값으로 초기화)
		System.out.printf("%s(%s)님 %d원 계좌 개설되었습니다\n", ownerName, accountNo, balance);
	}

	// 메소드 작성
	public void deposit(int money) { //예금은 양수 money가 들어오면 예금처리
		if(money>0) {
			balance += money;
			System.out.println(ownerName+"님 "+money+"원이 계좌에 입금되셨습니다.");
		}else {
			System.out.println("0보다 큰 금액만 가능합니다.\n");
		}
	}

	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
			System.out.println(ownerName+"님 "+money+"원이 출금 되었습니다.");
		} else {
			System.out.println(ownerName+"님 "+(money-balance)+"원 만큼 잔액이 부족합니다.");
		}
	}

	public String infoPrint() {// 홍길동(100-1)님 잔액 : 1000원
		// string.format을 쓰면 printf랑 같은 효과
		return String.format("%s(%s)님 잔액 : %d원\n", ownerName, accountNo, balance);
	}
	
	//setter & getter (자동완성 setAcc 친 다음 ctrl+space 활용 가능 똑같은 방법으로 get도 가능)
	//우클릭 source 후 generate 클릭 후 setter & getter 눌러서 추가 혹은 상단 메뉴 활용
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
