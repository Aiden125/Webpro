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
		if (state == STATE_BORROWED) { // 대출 중이면 메세지 뿌리고 끝
			System.out.println(getCdTitle() + " CD는 대출 중입니다.");
			return; // return되면 중단
		} // state가 0이라 대출처리 진행
		this.borrower = borrower;
		this.checkoutDate = checkoutDate;
		state = STATE_BORROWED; // 대출 중 상태로 전환
		System.out.println(getCdTitle() + " CD가 대출 처리되었습니다.");
		System.out.println("대출인 : " + borrower + "\t대출일 : " + checkoutDate);

	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getCdTitle() + "CD는 반납완료된 CD입니다. 예외발생");
			return; // return되면 중단
		}
		// state가 대출중(1)이라 반납 진행
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		System.out.println(getCdTitle() + "CD가 반납 완료되었습니다");
	}

	@Override
	public void printstate() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") 대출 가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") 대출 중");
		} else {
			System.out.println(getBookNo() + "\t" + getCdTitle() + ") 잘못된 값");
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
