package com.lec.quiz;
//if�� �ٿ��� �ۼ��غ���.
import java.util.Scanner;

// 0 <= Math.random() <1
// 0 <= Math.random()*3 <3
//0 <= (int)Math.random()*3 <3 : 0, 1, 2 �߿� �ϳ�
//��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�.
//��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� ������ �����ϰ��� �� ���� 1�� �Է��ϰ�,
//���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�
public class Quiz05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com = (int)(Math.random()*3);
		System.out.print("0(����), ����(1), ��(2) �� �ϳ� ����");
		you = sc.nextInt(); // ������ �Է¹���
		if (you == 0) {
			System.out.println("����� ����");
		} else if (you == 1) {
			System.out.println("����� ����");
		} else if (you == 2) {
			System.out.println("����� ��");
		} else {
			System.out.println("Wrong");
			you=3; // ������ ���� ����
		}
		if(you!=3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���(���� ������ Ȱ�� ����)
			String msg = (com==0)? "��ǻ�ʹ� ����" : (com==1)? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ��";
			System.out.println(msg);
		
			if((you+2)%3 == com) {
				System.out.println("����� �̰��.");
			}else if(you == com) {
				System.out.println("����");
			}else {
				System.out.println("����� ����.");
			}
			}
		}
}

