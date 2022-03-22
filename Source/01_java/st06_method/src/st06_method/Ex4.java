package st06_method;

import java.util.Scanner;
//사용자로부터 수를 입력받아 절대값을 출력하는 로직
public class Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 하나 입력하시오");
		int su = sc.nextInt();	
		System.out.println(su+"의 절대값은 : "+condition(su));
		sc.close();
	}
	private static int condition(int su) {
		return (su < 0) ? -su : su;
	}
}
