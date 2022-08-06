package wating_review;
import java.util.Scanner;

// 대문자와 소문자가 같이 존재하는 문자열을 입력받아
// 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
public class Step1_2_case1 {
	public String solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
			if(x>=97 && x<=122) {
				answer += (char)(x-32);
			}else {
				answer += (char)(x+32);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Step1_2_case1 T = new Step1_2_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
}
