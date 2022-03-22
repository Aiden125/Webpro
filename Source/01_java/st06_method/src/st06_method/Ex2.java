package st06_method;
// 다양한 메소드를 이용한 프린트
public class Ex2 {
	public static void main(String[] args) {
		printline();
		System.out.println("Hello, World!");
		printline('~');
		System.out.println("Hello, Java!");
		printline(40);
		System.out.println("Hello, Hello!");
		printline('ㅡ',30);
	}
	
	//매개변수 두 개짜리 메소드
	private static void printline(char c, int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	//매개변수 한 개짜리 메소드
	private static void printline(char c ) {
		for(int i = 0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	//매개변수 한 개짜리 메소드+오버로딩
	private static void printline(int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	//매개변수가 없는 메소드
	private static void printline() { 
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 얇은 '-' 30개 출력하고 개행
	}
}
