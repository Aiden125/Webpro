import java.util.Scanner;

public class step7_2292 {
	public static void main(String[] args) {
		int n; // �־����� ��ȣ
		int count=1; // ������� ������ ī��Ʈ
		int room=1; // ��Ī ������ ���� ũ��
		
		// 1�� ������ room=8
		// 2�� ������ room=20
		// �� �ѹ� ��ĥ������ room = room + (count*6)��ŭ �� �� �ִ�
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // ����
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
