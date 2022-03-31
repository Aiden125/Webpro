package com.lec.ex3_math;

import java.util.Random;

// �ζǹ�ȣ 6�� �̱�
public class Ex04 {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		
		//�ζǹ�ȣ 6�� ����
		for (int idx = 0; idx < lotto.length; idx++) { // Ȯ��for���� �� ��� ������ ������ �ȵż� Ȯ�� for���� ���� �ȵ�.
			// lotto[idx] = (random.nextInt(45) + 1); �迭�� �ߺ��� ���� �� �� �ִ� ���⿡ ����
			int temp = random.nextInt(45) + 1; //���� ������ �ӽ� ������ �����ϰ�
			boolean ok = true; // ���� ������ �ߺ��� �ƴҰ�� true / �ߺ��� ��� false
			for(int i=0 ; i<idx ; i++) {
				if(temp == lotto[i]) { //���� ������ �ߺ��Ǿ�����.
					idx--;
					ok = false;
					break; //�����ִ� for���� ���������� ���ִ� ����
				}
			} // for : �߻��� ������ ���� �չ濡 ����Ǿ����� Ȯ��(�ߺ��� ��������)
			if(ok) { //ok�� true�� lotto���� ������
				lotto[idx] = temp;
			}
		}
		
		//�������� ����
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		//����Ʈ
		for (int l : lotto) {
			System.out.print(l + " ");

		}
	}
}
