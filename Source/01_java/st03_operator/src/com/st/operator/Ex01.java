package com.st.operator;
// ���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���̸� �Է��ϼ��� : ");
		int su = scanner.nextInt(); //����ڷκ��� ���� �Է� �ޱ�
		String result = su > 65 ? "��ο��" : "�Ϲ�";
		System.out.println(result);
		scanner.close();
	}
}
