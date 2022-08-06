package step1;
import java.util.Scanner;

public class Step1_6 {
	public static void main(String[] args) {
		Step1_6 T = new Step1_6();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer="";
		for(int i=0; i<str.length(); i++) {
			if(str.indexOf(str.charAt(i))==i) {
				answer += str.charAt(i);
			}
		}
		return answer;
	}
}
