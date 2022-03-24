package com.lec.ex07_book3.copy.copy;

import com.lec.ex07_book1.ILendable;

public class BookLib extends BookInfo implements ILendable {
	private String borrower;
	private String checkoutDate;
	private byte state;

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // ���� ���̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + " ������ ���� ���Դϴ�.");
			return; // return�Ǹ� �ߴ�
		} // state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED; // ���� �� ���·� ��ȯ
		System.out.println(getBookTitle() + " ������ ���� ó���Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t������ : " + checkoutDate);

	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ��Ϸ�� å�Դϴ�. ���ܹ߻�");
			return; // return�Ǹ� �ߴ�
		}
		// state�� ������(1)�̶� �ݳ� ����
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}

	@Override
	public void printstate() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + "���� " + getWriter() + ") ���� ����");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + "���� " + getWriter() + ") ���� ��");
		} else {
			System.out.println(getBookNo() + "\t" + getBookTitle() + "(" + "���� " + getWriter() + ") �߸��� ��");
		}

	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public byte getState() {
		return state;
	}
}
