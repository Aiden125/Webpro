package z_test_pass;

import java.util.Scanner;
import java.util.Stack;

public class Step5_1 {
	public static void main(String[] args) {
		Step5_1 T = new Step5_1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x == '(') {
				stack.push(x);
			}else if(stack.isEmpty()) {
				return "NO";
			}else {
				stack.pop();
			}
		}
		if(!stack.isEmpty()) {
			return "NO";
		}
		return answer;
	}
}
