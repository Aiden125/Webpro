package st3_book;
// ������¿� ���� ����(2����)
// ����, �ݳ�, ���� �޼ҵ�
public interface ILendable {
	public byte STATE_BORROWED = 1; // ���� ��
	public byte STATE_NORMAL = 0; // ���� ����
	public void chedckOut(String borrower, String checkOutDate);
	public void checkIn(); // �ݳ�
	public void printstate(); // ���� ������ ���� ���� ���
	
}
