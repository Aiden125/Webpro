package com.lec.ex07_book3.copy.copy;

import com.lec.ex07_book1.ILendable;

public class CDLib extends CDInfo implements ILendable {
	private String borrower;
	private String checkoutDate;
	private byte state;

	public CDLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}

	@Override
	public void checkOut(String borrower, String checkoutDate) {
		if (state == STATE_BORROWED) { // ���� ���̸� �޼��� �Ѹ��� ��
			System.out.println(getCdTitle() + " CD�� ���� ���Դϴ�.");
			return; // return�Ǹ� �ߴ�
		} // state�� 0�̶� ����ó�� ����
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED; // ���� �� ���·� ��ȯ
		System.out.println(getCdTitle() + " CD�� ���� ó���Ǿ����ϴ�.");
		System.out.println("������ : " + borrower + "\t������ : " + checkoutDate);

	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getCdTitle() + "CD�� �ݳ��Ϸ�� CD�Դϴ�. ���ܹ߻�");
			return; // return�Ǹ� �ߴ�
		}
		// state�� ������(1)�̶� �ݳ� ����
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle() + "CD�� �ݳ� �Ϸ�Ǿ����ϴ�");
	}

	@Override
	public void printstate() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") ���� ����");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") ���� ��");
		} else {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") �߸��� ��");
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
