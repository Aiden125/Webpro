package com.lec.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class BookLib implements ILendable {
	private String bookNo; //책번호
	private String bookTitle; //책이름
	private String writer; //저자
	private String borrower; //대출인
	private Date checkOutDate; //대출일
	private byte state; //대출중이면 1 아니면 0
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	// BookLib book = new BookLib("91a-01", "java", "이고잉");
	// book.checkOut("홍길동") : 도서상태 확인 -> 대출로직 -> 도서상태출력
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state==STATE_BORROWED) { //state==1 즉, 대출중인 상태를 뜻하는데, 상수를 안쓰기에 상수 변수 이용
			throw new Exception(bookTitle + "도서는 ★대출중★입니다."); //강제로 예외 발생
		}
		//대출로직(여기로 내려왔다는건 state가 1이 아니라는 것. 즉 대출 가능하다는 것
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		//아래 형식으로 Date를 변환해주기
		//java도서가 대출되었습니다. 대출인:홍길동 / 대출일:2022-4-4(월) / 2주 이내에 반납하세요
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\"" + bookTitle + "\" 도서가 대출 되었습니다");
		System.out.println("대출인 : "+borrower + " / 대출일 : "+sdf.format(checkOutDate) + "2주 내로 반납하세요");
	}
	//book.checkIn() : 도서상태 확인 -> 연체여부 확인 -> 연체되었을 경우 연체료 납부y/n -> 반납로직 -> 도서상태출력
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아닌 도서입니다");
		}
		//연체여부 확인 checkOutDate ~ 현재까지 14일 이내인지 여부
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime(); //대출시점부터 현재까지의 밀리세컨
		long day = diff / (1000*60*60*24); //밀리세컨을 날짜로 계산해주기 위한 수식
		if(day > 14) { //연체여부
			System.out.println("연체료는 일일 100원 부과됩니다. 내셔야할 연체료는 " + (day-14)*100 + "원 입니다.");
			Scanner scanner = new Scanner(System.in);
			System.out.print("연체료를 내셨나요?(Y/N)");
			if(! scanner.next().equalsIgnoreCase("y")) { // Y를 입력하지 않은 경우
				System.out.println("연체료를 내셔야 반납처리가 가능합니다.");
				return; //return을 써서 다음 문장이 실행하지 않게.
			}
		}
		//반납로직(연체가 안된 경우에 해당되기 때문에)
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"도서가 반납되었습니다.");
	}
	//sysout(book) -> 책번호:91a-01 / 책이름:java / 저자:이고잉 대출가능
	//			   -> 책번호:91a-01 / 책이름:java / 저자:이고잉 대출중(대출일:2022-4-4(월))
	@Override
	public String toString() {
		String msg = "책번호 : " + bookNo + "\t책 이름 : " +bookTitle + "\t저자 : " + writer;
		msg += (state == STATE_NORMAL)? " 대출가능" : " 대출중";
		if(state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("(대출일 : yyyy-M-d(E))");
			msg += sdf.format(checkOutDate);
			//빌린시점 + 14일 => 달이 넘어가면 안나와서 일단 대출일로 계산
//			Date date = new Date(checkOutDate.getTime()+(1000*60*60*24*14)); //지금 이 시점
//			SimpleDateFormat sdf = new SimpleDateFormat("(반납예정일 : yyyy-M-d(E))");
//			msg += sdf.format(date);
		}
		return msg;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}
