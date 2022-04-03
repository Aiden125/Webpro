package st1_api;

import java.util.Scanner;

public class Ex2_regex {
	public static void main(String[] args) {
		String str = "010-2222-2222 moan125@naver.com (02)111-2222 �ݰ����ϴ�. Hello 92122-1213121";
		
		// System.out.println("replace =>" + str.replace("0", "ȫ")); //0�� ȫ���� �ٲ�,
		// �ܼ� replace�� �� ���� ��ȭ��ȣ�� ���ֹ�����, �ѱ��� ��������� �̷������� ���� ����.
		// ����ǥ���� ���� ����
		// 2.
		// \d(������) \D(���� ������ ��� ��) \s(whitespace ��, ����, �����̽�)
		// \w(�����ڳ� ����) \W(�����ڳ� ���ڰ� �ƴ� ����) .(�����ϳ�)
		// +(1���̻�)   *(0���̻�)   ?(0~1�� �ݺ�)   {2,4}(2~4ȸ �ݺ�)
		// 3.
		// ������  ��https://regexr.com/   ��https://www.regexpal.com/
		// ex. ��ȭ��ȣ : [(]?([0-9]){2,3}\D[0-9]{3,4}-[0-9]{4}
		//	       �̸��� : \w+@\w+(.\w+){1,2} ���ڳ� ���ڸ� 1���̻� �ݺ�+@���ڳ� ���ڿ��� 1���̳� �ι� �ݺ�
		// 4. Ư�� ����ǥ������ ���忭 ���� : replaceAll("����ǥ����", "��ü���ڿ�")
		
		//System.out.println(str.replaceAll("[0-9]",  "x")); // ���ڸ� x�� �ٲ��
		// System.out.println(str.replaceAll("\\d",  "x")); // �������ø� ǥ���Ϸ��� �ΰ������ ���ڸ� x�� �ٲ��
		//System.out.println(str.replaceAll("\\D",  "x")); // ���ڰ� �ƴѰ�(�����̽��� ������ ���ֹ���)
		
		//��ȭ��ȣ ����� ���
		System.out.println(str.replaceAll("[(]?([0-9]){2,3}\\D[0-9]{3,4}-[0-9]{4}", "**��ȭ��ȣ ����**"));
		//�̸��� ����� ���
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**�̸��� ����**"));
		//���ĺ� ��� *�� ��ü
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//�ѱ� �� �� ����
		System.out.println(str.replaceAll("[��-�R��-��]", "�ѱ�"));
		//�ֹι�ȣ ���ڸ��� *�� ��ü
		System.out.println(str.replaceAll("[0-9]{7}", "*******")); //[0-9]{7} ���ڸ� 7�� �ݺ��ϴ� ���̶�� �ǹ�
		
		
		
		

	}
}
