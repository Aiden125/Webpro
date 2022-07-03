import java.util.Scanner;

public class step7_2292 {
	public static void main(String[] args) {
		int n; // 주어지는 번호
		int count=1; // 몇번만에 가는지 카운트
		int room=1; // 서칭 가능한 방의 크기
		
		// 1번 지나면 room=8
		// 2번 지나면 room=20
		// 즉 한번 거칠때마다 room = room + (count*6)만큼 갈 수 있다
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 숫자
		if(n==1) {
			System.out.println(1);
		}else {
			while(room<n) {
				room += (count*6);
				count++;
			}
			System.out.println(count);
		}
	}
}
