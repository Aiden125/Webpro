package step8;
import java.util.Scanner;

public class step8_1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �ݺ� ����
		int cnt = 0; // �Ҽ��� �����
		
		for(int i=0; i<n; i++) {
			boolean sw = true; // �Ǵ� ����ġ ����� �ƴ϶��  false�� ����
			int num = sc.nextInt();
			if(num==1) { // 1�� ��� �Ҽ��� �ƴϴ�
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
