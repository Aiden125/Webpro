package com.lec.ex07_book3.copy.copy;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("a01", "java", "김자바"),
						new BookLib("a02", "python", "박이선"),
						new BookLib("a03", "oracle", "김기리"),
						new BookLib("a04", "web", "닭다리"),
						new BookLib("a05", "mysql", "김휴먼")};
		CDLib[] cds = { new CDLib("cd01", "java_cd", "a01"),
						new CDLib("cd02", "jsp_cd", "c01"),
						new CDLib("cd03", "ITtrend_cd", "e01"),
						new CDLib("cd03", "oracle_cd", "a03")};
		Scanner sc = new Scanner(System.in);
		//fn, idx등 여기서 선언한 이유가 for문 안에서 선언하면 for문이 끝나면 변수도 같이 종료되기 때문에
		int fn; //기능번호(1:대출 , 2:반납 , 3:책list , 0:종료)
		int idx; //대출하거나 반납하려고 할 때 조회된 책의 index
		int j;
		String bookTitle, cdTitle, borrower, checkOutDate; //사용자에게 받을 책이름, 대출인, 대출일
		
//		do {
//		System.out.println("1:대출 , 2:반납 , 3:책list , 0:종료");
//		fn = sc.nextInt();
//	}while(fn!=0);
		
		while(true) {
			System.out.println("1:책 대출 , 2:CD대출 , 3:책반납 , 4:CD반납 , 5:책list, 6:CD list , 0:종료");
			fn = sc.nextInt();
			if(fn==0) {
				break;
			}
			switch (fn) {
			case 1:
				System.out.print("대출하고자 하는 책 이름은?");
				bookTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if(idx==books.length) {
					System.out.println("현재 보유하지 않는 도서입니다.");
				}else {
					if(books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					}else {
						System.out.println("대출자는?");
						borrower = sc.next();
						System.out.println("대출일은?");
						checkOutDate = sc.next();
						books[idx].checkOut(borrower, checkOutDate);
							for(j=0 ; j<cds.length ; j++) {
								if(books[idx].getBookNo().equals(cds[j].getBookNo())) {
									if(cds[j].getState() == CDLib.STATE_NORMAL) {
										System.out.println("책과 세트인"+cds[j].getCdTitle()+"CD가 있습니다. 대출하시겠습니까(y/n)?");
										String answer = sc.next();
										if(answer.equals("y")) {
											cds[j].checkOut(borrower, checkOutDate);
											System.out.println("----------------------------------------");
										}
								}	
							}
						}
					}
				}
				break;
				
			case 2: 
				System.out.print("대출하고자 하는 CD 이름은?");
				cdTitle = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) {
					if(cdTitle.equals(cds[idx].getCdTitle())) {
						break;
					}
				}
				if(idx==cds.length) {
					System.out.println("현재 보유하지 않는 CD입니다.");
				}else {
					if(cds[idx].getState() == CDLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 CD입니다.");
					}else {
						System.out.println("대출자는?");
						borrower = sc.next();
						System.out.println("대출일은?");
						checkOutDate = sc.next();
						cds[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
				
			case 3: 
				System.out.print("반납할 책 이름은?");
				bookTitle = sc.next(); 
				for(idx=0 ; idx<books.length ; idx++) {
					if(bookTitle.equals(books[idx].getBookTitle())) {
						break;	
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책의 아닙니다.");
				}else {
					books[idx].checkIn();
				}
				break;
				
			case 4: 
				System.out.print("반납할 CD 이름은?");
				cdTitle = sc.next();
				for(idx=0 ; idx<cds.length ; idx++) {
					if(cdTitle.equals(cds[idx].getCdTitle())) {
						break;	
					}
				}
				
				if(idx == cds.length) {
					System.out.println("해당 CD는 본 도서관의 CD가 아닙니다.");
				}else {
					cds[idx].checkIn();
				}
				break;
				
			case 5:
				System.out.println("책 list는 다음과 같습니다.");
				for(BookLib book : books) {
					book.printstate();
				}
				break;
			
			case 6:
				System.out.println("CD list는 다음과 같습니다.");
				for(CDLib cd : cds) {
					cd.printstate();
				}
				break;
				
			case 0: break;
			}
		}System.out.println("BYE");
		sc.close();
	}//main
}//class
