package com.lec.ex07_book3.copy.copy;
// Book b = new Book("901¤±-101-2¤¤", "java", "±èÀÚ¹Ù")
public class CDInfo{
	private String cdNo;		
	private String cdTitle;	
	private String bookNo;	
	
	public CDInfo(String cdNo, String cdTitle, String bookNo) {
		super();
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
		this.bookNo = bookNo;
	}
	
	public String getCdNo() {
		return cdNo;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public String getBookNo() {
		return bookNo;
	}
}
