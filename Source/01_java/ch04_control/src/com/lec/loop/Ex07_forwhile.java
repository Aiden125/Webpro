package com.lec.loop;
// 1���� 100���� 3�� ����� �ո� ������ ������� ���Ͻÿ�
public class Ex07_forwhile {
	public static void main(String[] args) {
		int sum = 0;
		int i=1;
		while(i<101) {
			if(i%3==0) {
				sum += i;
			}
			++i;
		}
		System.out.println("3�� ��� ���� ����"+sum+"�Դϴ�");
	}
}
		
		
		
		
		
				
//		int sum = 0;
//		for(int i=1 ; i<101 ; i++) {
//			if(i%3 ==0) {
//				sum += i; // sum = sum+i;
//			} // if
//		} // for
//		System.out.println("��������"+sum);
//	}
//}
