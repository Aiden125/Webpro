package com.st05_array;

public class Ex01_array_for {
	public static void main(String[] args) {
		int[] arr = new int[3]; // 0 0 0���� �ʱ�ȭ ��{0 0 0} �� ����
		for(int idx=0 ; idx<arr.length ; idx++) { // �Ϲ� for�� �̿��� ���
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for(int temp : arr) { //Ȯ�� for���� �̿��� ���
			System.out.println(temp);
		}
		for(int i=0 ; i<arr.length ; i++) { // �Ϲ� for���� �̿��� �迭 ����
			arr[i] = 5;
		}
		for(int temp : arr) { // Ȯ�� for���� �̿��� �迭 ���� �Ұ���(�迭�� �ᱹ �״�� �����̱⿡)
			temp = 9;
		}
		
		for(int temp : arr) { // Ȯ�� for���� �̿��� ��� arr���� �ȹٲ�� ������ ���� ������ 5���� �״�� ��µǴ°� ����
			System.out.println(temp);
		}
	}
}
