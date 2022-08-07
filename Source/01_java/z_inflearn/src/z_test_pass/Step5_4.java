package z_test_pass;

import java.util.Scanner;
import java.util.Stack;

// 후위식 연산
// 연산자가 주어지면 앞에 두개를 꺼내고,
// 각각 lt, rt로 저장해 연산을 해준 뒤 다시 스택에 넣는다
public class Step5_4 {
	public static void main(String[] args) {
		Step5_4 T = new Step5_4();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public int solution(String str) {
		int answer = 0;
		int lt = 0;
		int rt = 0;
		Stack<Integer> stack = new Stack<>();
		for(char x : str.toCharArray()) {
			if((int)x >= 48 && (int)x <= 57) {
				stack.push(((int)x - 48));
			}else {
				rt = stack.pop();
				lt = stack.pop();
				if(x == '+') {
					stack.push((lt + rt));
				}else if(x == '*') {
					stack.push((lt * rt));
				}else if(x == '-') {
					stack.push((lt - rt));
				}else{
					stack.push((lt / rt));
				}
			}
		}
		answer = stack.get(0);
		
		return answer;
	}
}
