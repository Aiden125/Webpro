package com.lec.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("0~45�̸��� double ����"+Math.random()*45);
		System.out.println("0~45�̸��� ���� ����"+(int)(Math.random()*45));
		System.out.println("�ζ� ��ȣ �̱�(1���� 46���� ���� ����) : "+((int)(Math.random()*45)+1)); //��ȣ����. �߸��ϸ� ��갪�� 1�� �پ�ͼ� ��鳪��
		Random random = new Random();
		System.out.println("int ���� : " + random.nextInt());
		System.out.println("doulbe ���� : "+ random.nextDouble()); //math.random�� �Ȱ����� import�� �ʿ�.
		System.out.println("T/F �� �ϳ� ���� : " + random.nextBoolean());
		System.out.println("0~2������ ���� ���� : " + random.nextInt(3)); // ������ ��谪�Է� 0~3 �̸��� ���� ����
		System.out.println("0~45������ ���� ���� : " + random.nextInt(46)); // ������ ��谪�Է� 0~46 �̸��� ���� ����
		System.out.println("�ζ� ��ȣ �̱� : " + (random.nextInt(45)+1));
	}
}
