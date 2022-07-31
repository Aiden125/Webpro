package review_yet;
import java.util.Scanner;
import java.util.Stack;
// 1. ������ �����
// 2. ���� ��ȣ Ǫ��
// 3. �ݴ� ��ȣ�� �������� �ݴ°�����, �踷����� ������(������ ����� '('�̸� ������)

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
			if (str.charAt(i) == '(') { // ���� ��ȣ�� �ϴ� �ֱ�(������ ���� �踷������� ��)
				stack.push('(');
			} else {
				if (str.charAt(i-1) == '(') {// case1. �������� ���
					stack.pop();
					answer += stack.size();
				} else {// case2. �踷��� ���� ���
					stack.pop();
					answer++;
				}
			}
		}

		return answer;
	}
}
