package ex6;
//a1���� ���¹�ȣ�� ������ ���°��� �Ա� �ι� ��� �ι�
//a2���� ���¹�ȣ, �̸�, ���ݾ�, ī���ȣ�� ī�� ����. �Ա�, ��� �� ����,
//a3���� ���¹�ȣ, �̸�, ���ݾ�, ī���ȣ, �ѵ��� �ſ�ī�� ����
public class TestMain {
	public static void main(String[] args) {
		Account a1 = new Account("111-1234", "ȫ�浿");
		a1.deposit(3000);
		a1.deposit(6000);
		a1.withdraw(5000);
		a1.withdraw(10000);
		System.out.println("---------------------------");
		CheckingAccount a2 = new CheckingAccount("123-1234", "������", "1234-1234-5678");
		a2.deposit(10000);
		a2.withdraw(20000);
		a2.pay("1234-1234-5678", 5000);
		a2.pay("1234-1234-5678", 10000);
		System.out.println("---------------------------");
		CreditLineAccount a3 = new CreditLineAccount("121-1212", "����", "7777-7777-7777", 100000000);
		a3.deposit(50000000);
		a3.pay("7777-7777-7777", 50000000);
		a3.pay("7777-7777-7777", 50000);
	}
	
}
