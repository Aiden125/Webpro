package step1;
import java.util.Scanner;

public class Step1_7 {
	public static void main(String[] args) {
		Step1_7 T = new Step1_7();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "NO";
		str = str.toLowerCase();
		String temp = "";
		for(int i=str.length()-1; i>=0; i--) {
			temp += str.charAt(i);
		}
		if(str.equals(temp)) {
			answer = "YES";
		}
		return answer;
	}
}
