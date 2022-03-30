package st3_book;
// Book b = new Book("911-101-2a", "java", "김자바")
public class Book implements ILendable {
	private String bookNo;//책번호
	private String bookTitle; //책제목
	private String writer; //저자
	private String borrower; //대출인
	private String checkOutDate; //대출날짜
	private byte state; // 대출상태
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void chedckOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println("해당 도서는 이미 대출 중입니다.");
			return; //return되면 중단.
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " 도서가 대출 처리되었습니다.");
		System.out.println("대출인 : "+borrower + "\t 대출일 : "+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println("이미 반납처리 된 책입니다. 관리자에게 문의하세요");
			return; // return 되면 중단
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " 도서가 반납 완료 되었습니다.");

	}

	@Override
	public void printstate() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + );
		}

	}

}
