package st3_book;
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
			System.out.println(bookNo + );
		}

	}

}
