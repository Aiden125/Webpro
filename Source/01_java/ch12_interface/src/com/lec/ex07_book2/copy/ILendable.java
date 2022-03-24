package com.lec.ex07_book2.copy;
// Book 작업명세
public interface ILendable {
	public byte STATE_BORROWED = 1; //"대출 중"
	public byte STATE_NORMAL = 0; //"대출 가능"
	public void checkOut(String borrower, String checkoutDate); // 대출 시 대출인과 대출일 이용
	public void checkIn(); //반납
	public void printstate(); //도서 정보와 대출 상태 출력
}
