package com.lec.ex07_book3.copy.copy;
// Book b = new Book("901��-101-2��", "java", "���ڹ�")
public class BookInfo{
	private String bookNo;		//å��ȣ 901��-101-2��
	private String bookTitle;	//å����
	private String writer;		//����
	
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
