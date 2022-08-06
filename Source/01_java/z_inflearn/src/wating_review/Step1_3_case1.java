package wating_review;
import java.util.Scanner;

public class Step1_3_case1 {
	public static void main(String[] args) {
		Step1_3_case1 T = new Step1_3_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "";
		int m = -1;
		String[] s = str.split(" "); // 잘라주기
		for(String x : s) {
			if(x.length()>m) {
				m = x.length();
				answer = x;
			}
		}		
		return answer;
	}
}
