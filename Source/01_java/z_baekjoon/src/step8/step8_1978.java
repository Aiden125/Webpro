package step8;
import java.util.Scanner;

public class step8_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 반복 갯수
		int cnt = 0; // 소수가 몇개인지
		
		for(int i=0; i<n; i++) {
			boolean sw = true; // 판단 스위치 약수가 아니라면  false로 변경
			int num = sc.nextInt();
			if(num==1) { // 1인 경우 소수가 아니다
				continue;
			}
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num%j == 0) {
					sw = false;
					break;
				}
			}
			if(sw) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
