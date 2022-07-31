package review_yet;
import java.util.Scanner;
import java.util.Stack;
// 1. 스택을 만든다
// 2. 여는 괄호 푸시
// 3. 닫는 괄호는 레이저의 닫는것인지, 쇠막대기의 끝인지(스택의 상단이 '('이면 레이저)

public class Step5_5_case2 {
	public static void main(String[] args) {
		Step5_5_case2 T = new Step5_5_case2();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}

	public int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(') { // 여는 괄호면 일단 넣기(레이저 인지 쇠막대기인지 모름)
				stack.push('(');
			} else {
				if (str.charAt(i-1) == '(') {// case1. 레이저인 경우
					stack.pop();
					answer += stack.size();
				} else {// case2. 쇠막대기 끝인 경우
					stack.pop();
					answer++;
				}
			}
		}

		return answer;
	}
}
