package step3;
import java.util.Scanner;

public class Step3_6 {
	public static void main(String[] args) {
		Step3_6 T = new Step3_6();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(n, k, arr));
	}
	
	public int solution(int n, int k, int[] arr) {
		int answer = 0;
		int sum=0, lt=0, limit=0;
		
		for(int rt=0; rt<n; rt++) {
			if(arr[rt]==1) sum++; // 1�� ��� sum�� �����ֱ�
			if(arr[rt]==0) {
				limit++;
				sum++;
				while(limit>k) { // ���� Ƚ���� �Ѿ�ٸ� �� ���� -1 ���ְ�
					sum--;
					if(arr[lt]==0) {// 0�� ��츦 �پ���� �Ÿ� ���� 1ȸ Ǯ��
						limit--;
						lt++;
					}else {
						lt++;						
					}
				}
			}
			if(answer < sum) answer=sum;
		}
		return answer;
	}
}
