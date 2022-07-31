package review_yet;
import java.util.Scanner;
import java.util.Stack;
// 1. ������ �����
// 2. ���� ��ȣ Ǫ��
// 3. �ݴ� ��ȣ�� �������� �ݴ°�����, �踷����� ������(������ ����� '('�̸� ������)

public class Step5_5_case1_wrong {
	public static void main(String[] args) {
		Step5_5_case1_wrong T = new Step5_5_case1_wrong();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}

	public int solution(String str) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		for (char x : str.toCharArray()) {
			if (x == '(') { // ���� ��ȣ�� �ϴ� �ֱ�(������ ���� �踷������� ��)
				stack.push(x);
			} else {
				if (stack.peek() == '(') {// case1. �������� ���
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
