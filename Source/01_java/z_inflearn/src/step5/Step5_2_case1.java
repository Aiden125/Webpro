package step5;
import java.util.Scanner;
import java.util.Stack;

public class Step5_2_case1 {
	public static void main(String[] args) {
		Step5_2_case1 T = new Step5_2_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	
	
	public String solution(String str) {
		String answer="";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(x == ')') {
				while(stack.pop() != '('); // stack.pop은 꺼내면서 그 값 자체를 리턴한다
			}else {
				stack.push(x);
			}
		}
		
		for(int i=0; i<stack.size(); i++) {
			answer += stack.get(i);
		}
		return answer;
	}
}
