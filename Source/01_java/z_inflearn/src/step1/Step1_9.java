package step1;
import java.util.Scanner;

public class Step1_9 {
	public static void main(String[] args) {
		Step1_9 T = new Step1_9();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "";
		String temp = "";
		for(char x : str.toCharArray()) {
			if((int)x >= 48 && (int)x <= 57) {
				temp += x;
			}
		}
		
		boolean sw = false;
		for(char x : temp.toCharArray()) {
			if((int)x == 48 && !sw) {
				continue;
			}else {
				sw = true;
				answer += x;
			}
		}
		return answer;
	}
}
