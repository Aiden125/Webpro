package com.lec.loop;
// 2�ܺ��� �����ϴ� �������� ����ϴ� ���α׷��� ������ ����
// ��, �� ���� ������ ������ �ٲپ� ǥ���϶�
public class Quiz04 {
	public static void main(String[] args) {
		for(int i=1 ; i<10 ; i++) { // 1~9����
			for(int j=2 ; j<10 ; j++) { // 2�ܺ��� 9�ܱ���
				System.out.printf("%d * %d = %d\t", j, i, j*i);
			}
			System.out.println(); // ����
		}
	}
}
		
		
// ������ �ۼ��� �ڵ�		
// 			for(int i=2 ; i<=9 ; i++) {
//			for(int j=1 ; j<=10 ; j++) {
//				int tot = i*j;
//				if(j==10) {
//					System.out.println();
//				} else
//				System.out.print(i+"*"+j+'='+tot+"\t");
//			}
//			}
//		}
//	}