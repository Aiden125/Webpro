package st06_method;
// �پ��� �޼ҵ带 �̿��� ����Ʈ
public class Ex2 {
	public static void main(String[] args) {
		printline();
		System.out.println("Hello, World!");
		printline('~');
		System.out.println("Hello, Java!");
		printline(40);
		System.out.println("Hello, Hello!");
		printline('��',30);
	}
	
	//�Ű����� �� ��¥�� �޼ҵ�
	private static void printline(char c, int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	//�Ű����� �� ��¥�� �޼ҵ�
	private static void printline(char c ) {
		for(int i = 0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	//�Ű����� �� ��¥�� �޼ҵ�+�����ε�
	private static void printline(int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	//�Ű������� ���� �޼ҵ�
	private static void printline() { 
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // ���� '-' 30�� ����ϰ� ����
	}
}
