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
				if(st.isEmpty()) { // �ݴ� ��ȣ�� ���� ���
					return "NO";
				}else {
					st.pop();
				}
			}
		}
		
		if(!st.isEmpty()) { // �� ���� ���� ��ȣ�� �����ִ� ���
			return "NO";
		}
		return answer;
	}
}
