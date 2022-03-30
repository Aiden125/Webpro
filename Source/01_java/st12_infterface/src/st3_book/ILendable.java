package st3_book;
// 대출상태에 관한 변수(2가지)
// 대출, 반납, 상태 메소드
public interface ILendable {
	public byte STATE_BORROWED = 1; // 대출 중
	public byte STATE_NORMAL = 0; // 대출 가능
	public void chedckOut(String borrower, String checkOutDate);
	public void checkIn(); // 반납
	public void printstate(); // 도서 정보와 대출 상태 출력
	
}
