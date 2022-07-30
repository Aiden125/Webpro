package review_yet;
import java.util.Scanner;
import java.util.Stack;

public class Step5_4_case1 {
	public static void main(String[] args) {
		Step5_4_case1 T = new Step5_4_case1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	
	
	public int solution(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		int lt, rt;
		for(Character x : str.toCharArray()) {
			if((int) x < 58 && (int)x >=48) {
				stack.push(x - 48);
			}else {
				rt = stack.pop();
				lt = stack.pop();
				if(x == '+') {
					stack.push(lt+rt);
				}
				else if(x == '*') {
					stack.push(lt*rt);
				}
				else if(x == '-') {
					stack.push(lt-rt);
				}
				else if(x == '/') {
					stack.push(lt/rt);
				}
			}
		}
		answer = stack.get(0);
		
		return answer;
	}
}
