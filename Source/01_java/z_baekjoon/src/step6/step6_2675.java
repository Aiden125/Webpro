package step6;
import java.util.Scanner;

public class step6_2675 {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt(); // �׽�Ʈ ����
		for(int i=0; i<t; i++) {
			
			// ���� ������ �׽�Ʈ ����Ŭ
			int r = sc.nextInt(); // �ݺ�Ƚ��
			String s = sc.next(); // ���ڿ�
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
