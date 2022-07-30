package review_yet;
import java.util.Scanner;
import java.util.Stack;

public class Step5_1_case1 {
	public static void main(String[] args) {
		Step5_1_case1 T = new Step5_1_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	
	public String solution(String str) {
		String answer = "YES";
		Stack<Character> st = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x == '(') {
				st.push(x);
			}else {
				if(st.isEmpty()) { // 닫는 괄호가 많은 경우
					return "NO";
				}else {
					st.pop();
				}
			}
		}
		
		if(!st.isEmpty()) { // 다 돌고도 여는 괄호가 남아있는 경우
			return "NO";
		}
		return answer;
	}
}
