package z_test_pass;

import java.util.Scanner;
import java.util.Stack;

// '(' �Է¹����� Ǫ��
// ')' ������ pop�ϱ� ��������? pop�Ѱ� '(' �� ������
public class Step5_2 {
	public static void main(String[] args) {
		Step5_2 T = new Step5_2();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "";
		Stack<Character> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if(!(x == ')')) {
				stack.push(x);
			}else {
				while(true) {
					if(stack.pop()=='(') {
						break;
					}
				}
			}
		}
		for(int i=0; i<stack.size(); i++) {
			answer += stack.get(i);
		}
		return answer;
	}
}
