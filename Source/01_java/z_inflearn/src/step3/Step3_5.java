package step3;
import java.util.Scanner;

public class Step3_5 {
	public static void main(String[] args) {
		Step3_5 T = new Step3_5();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(T.solution(n));
	}
	
	public int solution(int n) {
		int answer = 0;
		int lt=0, rt=1, sum=1;
		while(rt<=((n/2)+2)) {
			if(sum==n) {
				answer++;
				sum = sum - (lt++) + (++rt); 
			}else if(sum<n) {
				sum += ++rt;
			}else {
				sum -= lt++;
			}
		}
		return answer;
	}
}
