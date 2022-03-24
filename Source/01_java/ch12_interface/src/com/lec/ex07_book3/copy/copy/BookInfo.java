package com.lec.ex07_book3.copy.copy;
// Book b = new Book("901ㅁ-101-2ㄴ", "java", "김자바")
public class BookInfo{
	private String bookNo;		//책번호 901ㅁ-101-2ㄴ
	private String bookTitle;	//책제목
	private String writer;		//저자
	
	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
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
	

}
