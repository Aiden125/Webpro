package st4_book;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Book[] books = {new Book("901ㅁ-101-2ㄴ", "java", "김자바"),
				new Book("331ㄴ-122-2ㄴ", "python", "박이선"),
				new Book("661ㅇ-199-2ㄴ", "oracle", "올아클"),
				new Book("231ㄹ-155-2ㄴ", "web", "닭다리"),
				new Book("651ㄷ-166-2ㄴ", "mysql", "김큐엘")};
		 Scanner sc = new Scanner(System.in);
		 
		 //여기다 선언해야  for문이 끝나더라도 유지되기에 여기 선언
		 int fn;//기능번호(1:대출, 2:반납, 3:책list, 0:종료)
		 int idx;//대출하거나 반납하려고 할 때 조회된 책의 index
		 String bookTitle, borrower, checkOutDate;//사용자에게 받을 책이름, 대출인, 대출날짜
		 
		 while(true) {
			 System.out.println("1:대출, 2:반납, 3:책리스트, 0:종료");
			 fn = sc.nextInt();
			 if(fn==0) {
				 break;
			 }
			 switch(fn) {
				 case 1: //대출처리 : 1.책이름 입력  2.책조회  3.책상태확인  4.대출인입력  5.대출일입력  6.대출메소드 호출
					 System.out.println("대출하고자 하는 책 이름은?");
					 bookTitle = sc.next();
					 for(idx=0 ; idx<books.length ; idx++) {
						 if(bookTitle.equals(books[idx].getBookTitle())) {
							 break;
						 }
					 }
					 if(idx==books.length) {
						 System.out.println("현재 보유하지 않은 도서입니다.");
					 }else {
						 if(books[idx].getState() == Book.STATE_BORROWED) {
							 System.out.println("현재 대출중인 도서입니다.");
						 }else {
							 System.out.println("대출자는?");
							 borrower = sc.next();
							 System.out.println("대출일은?");
							 checkOutDate = sc.next();
							 books[idx].chedckOut(borrower, checkOutDate);
						 }
					 }
					 break;
					 
				 case 2:
					 System.out.println("반납할 책 이름은?");
					 bookTitle = sc.next();
					 for(idx=0 ; idx<books.length ; idx++) {
						 if(bookTitle.equals(books[idx].getBookTitle())) {
							 break;
						 }
					 }
					 if(idx == books.length) {
						 System.out.println("해당 도서는 본 도서관의 책이 아닙니다.");
					 }else {
						 books[idx].checkIn();
					 }
					 break;
				 case 3:
					 System.out.println("책리스트는 다음과 같습니다.");
					 for(Book book : books) {
						 book.printstate();
					 }
					 break;
				 case 0: break;
			 }
		 }System.out.println("BYE");
		 
		 
	}
}
