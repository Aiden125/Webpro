package com.st.loop;
//dowhile�� Ȱ���� ���������� ���α׷�(��ǻ�Ϳ� �ּ� 1���� ������������ �����϶�)
import java.util.Scanner;

public class Ex04_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com ;
		do {
			com = (int)(Math.random()*3);
			System.out.println("����(0) ����(1) ��(2) �� �ϳ� ������ : ");
			you = sc.nextInt();
			if(you!=3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���(���� ������ Ȱ�� ����)
				String msg = (com==0)? "��ǻ�ʹ� ����" : (com==1)? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ��";
				System.out.println(msg);
			
				if((you+2)%3 == com) {
					System.out.println("����� �̰��.");
				}else if(you == com) {
					System.out.println("����");
				}else {
					System.out.println("����� ����."); break;
				}
			}
		}while(true);
		System.out.println("�ȳ��� ������");
	}
}

