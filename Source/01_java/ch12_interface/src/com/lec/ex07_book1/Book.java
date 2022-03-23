package com.lec.ex07_book1;
// Book b = new Book("901ㅁ-101-2ㄴ", "java", "김자바")
public class Book implements ILendable {
	private String bookNo;		//책번호 901ㅁ-101-2ㄴ
	private String bookTitle;	//책제목
	private String writer;		//저자
	private String borrower;	//대출인
	private String checkOutDate;//대출일
	private byte state;			//대출 상태(대출 중1, 대출 가능0)
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		
		//밑에 이런값들 굳이 안넣어도 됨
//		borrower = null;
//		checkOutDate = null;
//		state = STATE_NORMAL;
	}
	// state = STATE_NORMAL;
	// b.checkOut("신길동", "03-23"); 대출 : 상태를 확인해서 대출 중이면 중단, 대출 가능이면 대출처리
	@Override
	public void checkOut(String borrowe, String checkoutDate) {
		if(state == STATE_BORROWED) { //대출 중이면 메세지 뿌리고 끝
			System.out.println(bookTitle + " 도서는 대출 중입니다.");
			return; // return되면 중단
		}// state가 0이라 대출처리 진행
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; //대출 중 상태로 전환
		System.out.println(bookTitle + " 도서가 대출 처리되었습니다.");
		System.out.println("대출인 : "+borrower + "\t대출일 : "+checkoutDate);

	}
	//b.checkIn() 반납 : state 확인해서 대출가능(0)이면 메세지 뿌리고 중단, 대출중(1) 반납진행
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println(bookTitle+"도서는 반납완료된 책입니다. 예외발생");
			return; // return되면 중단
		}
		// state가 대출중(1)이라 반납 진행
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다");		
	}
	//b.printState() => 901ㅁ-101-2ㄴ java(저자 홍길동) 대출중
	@Override
	public void printstate() {
		if(state==STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + "저자 " + writer + ") 대출 가능");
		}else if(state==STATE_BORROWED){
			System.out.println(bookNo + "\t" + bookTitle + "(" + "저자 " + writer + ") 대출 중");
		}else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + "저자 " + writer + ") 잘못된 값");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + "저자" + writer + ")";
//		msg = msg + ((state==STATE_NORMAL)? "대출가능" : (state==STATE_BORROWED)? "대출중" : "잘못된 값");
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
