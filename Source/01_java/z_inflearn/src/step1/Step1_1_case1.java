package step1;
import java.util.Scanner;
// 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
// 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
public class Step1_1_case1 {
	public int solution(String str, char c) {
		int count=0;
		str=str.toUpperCase();
		c=Character.toUpperCase(c);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == c) {
				count++;
			}
		}
		
		return count;
	}
				
	public static void main(String[] args) {
		Step1_1_case1 T = new Step1_1_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		System.out.println(T.solution(str, c));
	}
}
