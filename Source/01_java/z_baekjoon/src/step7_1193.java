import java.util.Scanner;

public class step7_1193 {
	public static void main(String[] args) {
		int x; // �־����� ��ȣ
		int count=1; // ������� ������ ī��Ʈ
		int room=2; // ��Ī ������ ���� ũ��
		
		// 1�� ������ room=8
		// 2�� ������ room=20
		// �� �ѹ� ��ĥ������ room = room + (count*6)��ŭ �� �� �ִ�
		
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt(); // ����
		if(x==1) {
			System.out.println(1);
		}else {
			while(room<x) {
				room += (count);
				count++;
			}
			System.out.println(count);
		}
	}
}
