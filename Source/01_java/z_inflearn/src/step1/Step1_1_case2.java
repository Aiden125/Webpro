package step1;
import java.util.Scanner;
// �� ���� ���ڿ��� �Է¹ް�, Ư�� ���ڸ� �Է¹޾� �ش� Ư�����ڰ� �Է¹��� ���ڿ��� �� �� �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��ϼ���.
// ��ҹ��ڸ� �������� �ʽ��ϴ�.���ڿ��� ���̴� 100�� ���� �ʽ��ϴ�.
public class Step1_1_case2 {
	public int solution(String str, char c) {
		int count=0;
		str=str.toUpperCase();
		c=Character.toUpperCase(c);
		for(char x : str.toCharArray()) { // ��Ʈ���� �� ���ڷ� �߶� �迭�� ����
			if(x==c) {
				count++;
			}
		}
		
		return count;
	}
				
	public static void main(String[] args) {
		Step1_1_case2 T = new Step1_1_case2();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = sc.next().charAt(0);
		System.out.println(T.solution(str, c));
	}
}
