package com.lec.ex2_human.main;

//com.lec.ex2_human ��Ű���� ��� class import
//������ �� ������ ���� ctrl+shift+o ������ import �ʿ��� �͸� �ְ��ϴ°� ����
import com.lec.ex2_human.*;

public class TestMain {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		// ���ʵ����� Ÿ�Կ����� ������ ���� ���� ==���� ����
		System.out.println(i == j ? "����" : "�ٸ���");

		// ���۷��� ����
		String name = new String("�浿��");
		// ������ ����ó�� ����ϴµ� String�� �˾Ƽ� ��ȯ����
		String name2 = "�浿��";
		// ���⼭ �ٽ� ���Ǹ� �ϴ��� ���� ������ �ִ� �浿�̸� ����Ŵ �ּҵ� ����
		// �׷��� ==�� �ƴ� equals �Լ��� �Ἥ ���ؾ���
		if (name.equals(name2)) {
			System.out.println("name�� name2�� ����.");
		}

		// �Ʒ� �� ���̴� ���� �ٸ� ����(�Ҵ�Ǵ� �ּҰ� �ٸ�)
		// ���ο� ��ü Ÿ�� ����
		Woman hee1 = new Woman();
		Woman hee2 = new Woman();
		if (hee1.equals(hee2)) { // equals�� ������ �⺻������ ��ӵ�
			System.out.println("hee1�� hee2�� ����.");
		}
		Man Kang = new Man(22, 165, 60.3);
		Man Kim = new Man(22, 188, 99.9);
		Man Kim1; // ���۷��� ���� ����(��ü����) ����
		Kim1 = Kim;
		Man Kim2 = new Man(22, 188, 99.9);
		if (Kim.equals(Kim1)) {
			System.out.println("Kim�� Kim1�� ���� ��, ���� �ּҰ��� ����Ų��.");
		}
		// if+equals �� �� ����ǥ�� �̷��� ���̸� �ٸ��ٴ� �������� ����
		if (!Kim.equals(Kim2)) {
			System.out.println("Kim�� Kim2�� �ٸ��� ��, �ٸ� �ּҰ��� ����Ų��.");
		} else {
			System.out.println("Kim�� Kim2�� ����.");
		}
		Kang.setHeight(160);
		Kang.setWeight(99); // ���� double�� �����߱⿡ double�� �������� ����ȯ ��
		if(Kang.calculateBMI() > 30) {
			System.out.println("�ǰ��ϼ���");
		}else {
			System.out.println("�ǰ��ϰڳ׿�");
		}

	}

}
