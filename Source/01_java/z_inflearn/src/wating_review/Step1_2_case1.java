package wating_review;
import java.util.Scanner;

// �빮�ڿ� �ҹ��ڰ� ���� �����ϴ� ���ڿ��� �Է¹޾�
// �빮�ڴ� �ҹ��ڷ� �ҹ��ڴ� �빮�ڷ� ��ȯ�Ͽ� ����ϴ� ���α׷��� �ۼ��ϼ���.
public class Step1_2_case1 {
	public String solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
			if(x>=97 && x<=122) {
				answer += (char)(x-32);
			}else {
				answer += (char)(x+32);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Step1_2_case1 T = new Step1_2_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
}
