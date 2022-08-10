import java.util.Scanner;

public class Step3_4_wrong {
	public static void main(String[] args) {
		Step3_4_wrong T = new Step3_4_wrong();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, m, arr));
	}
	
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		int lt=0, rt=0;
		int sum = arr[0];
		while(rt<n-1) {
			if(sum==m) {
				answer++;
				sum = sum + arr[++rt] - arr[lt++];
			}else if(sum < m) {
				sum += arr[++rt];
			}else {
				sum -= arr[lt++];
			}
		}
		if(sum==m) answer++; // 마지막 rt 더했을 때 참인 경우
		return answer;
	}
}
