package wating_review;
import java.util.Scanner;

// �빮�ڿ� �ҹ��ڰ� ���� �����ϴ� ���ڿ��� �Է¹޾�
// �빮�ڴ� �ҹ��ڷ� �ҹ��ڴ� �빮�ڷ� ��ȯ�Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
public class Step1_2_case2 {
	public String solution(String str) {
		String answer="";
		for(char x : str.toCharArray()) {
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			}else {
				answer += Character.toLowerCase(x);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Step1_2_case2 T = new Step1_2_case2();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
}
