package st4_book;
// Book b = new Book("911-101-2a", "java", "���ڹ�")
public class Book implements ILendable {
	private String bookNo;//å��ȣ
	private String bookTitle; //å����
	private String writer; //����
	private String borrower; //������
	private String checkOutDate; //���⳯¥
	private byte state; // �������
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void chedckOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) {
			System.out.println("�ش� ������ �̹� ���� ���Դϴ�.");
			return; //return�Ǹ� �ߴ�.
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println(bookTitle + " ������ ���� ó���Ǿ����ϴ�.");
		System.out.println("������ : "+borrower + "\t ������ : "+checkOutDate);
	}

	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) {
			System.out.println("�̹� �ݳ�ó�� �� å�Դϴ�. �����ڿ��� �����ϼ���");
			return; // return �Ǹ� �ߴ�
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + " ������ �ݳ� �Ϸ� �Ǿ����ϴ�.");

	}

	@Override
	public void printstate() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "���Ⱑ��");
		}else if(state==STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "���� ��");
		}else {
			System.out.println("�߸��� ���Դϴ�.");
		}
		
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
