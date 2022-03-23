package com.lec.ex07_book1;
// Book b = new Book("901��-101-2��", "java", "���ڹ�")
public class Book implements ILendable {
	private String bookNo;		//å��ȣ 901��-101-2��
	private String bookTitle;	//å����
	private String writer;		//����
	private String borrower;	//������
	private String checkOutDate;//������
	private byte state;			//���� ����(���� ��1, ���� ����0)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		
		//�ؿ� �̷����� ���� �ȳ־ ��
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL;
	}
	// state = STATE_NORMAL;
	// b.checkOut("�ű浿", "03-23"); ���� : ���¸� Ȯ���ؼ� ���� ���̸� �ߴ�, ���� �����̸� ����ó��
	@Override
	public void checkOut(String borrowe, String checkoutDate) {
		if(state == STATE_BORROWED) { //���� ���̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + " ������ ���� ���Դϴ�.");
			return; // return�Ǹ� �ߴ�
		}// state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; //���� �� ���·� ��ȯ
		System.out.println(bookTitle + " ������ ���� ó���Ǿ����ϴ�.");
		System.out.println("������ : "+borrower + "\t������ : "+checkoutDate);

	}
	//b.checkIn() �ݳ� : state Ȯ���ؼ� ���Ⱑ��(0)�̸� �޼��� �Ѹ��� �ߴ�, ������(1) �ݳ�����
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+"������ �ݳ��Ϸ�� å�Դϴ�. ���ܹ߻�");
			return; // return�Ǹ� �ߴ�
		}
		// state�� ������(1)�̶� �ݳ� ����
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");		
	}
	//b.printState() => 901��-101-2�� java(���� ȫ�浿) ������
	@Override
	public void printstate() {
		if(state==STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + "���� " + writer + ") ���� ����");
		}else if(state==STATE_BORROWED){
			System.out.println(bookNo + "\t" + bookTitle + "(" + "���� " + writer + ") ���� ��");
		}else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + "���� " + writer + ") �߸��� ��");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + "����" + writer + ")";
//		msg = msg + ((state==STATE_NORMAL)? "���Ⱑ��" : (state==STATE_BORROWED)? "������" : "�߸��� ��");
//		System.out.println(msg);

	}
	public String getBookNo() {
		return bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public String getBorrower() {
		return borrower;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public byte getState() {
		return state;
	}

}
