package st06_method;

import java.util.Scanner;
//����ڷκ��� ���� �Է¹޾� ���밪�� ����ϴ� ����
public class Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �ϳ� �Է��Ͻÿ�");
		int su = sc.nextInt();	
		System.out.println(su+"�� ���밪�� : "+condition(su));
		sc.close();
	}
	private static int condition(int su) {
		return (su < 0) ? -su : su;
	}
}
