package step6;
import java.util.Scanner;

public class step6_2675 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt(); // 테스트 갯수
		for(int i=0; i<t; i++) {
			
			// 실제 진행할 테스트 사이클
			int r = sc.nextInt(); // 반복횟수
			String s = sc.next(); // 문자열
			for(int j=0; j<s.length(); j++) {
				for(int z=0; z<r; z++) {
					sb.append(s.charAt(j));
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
