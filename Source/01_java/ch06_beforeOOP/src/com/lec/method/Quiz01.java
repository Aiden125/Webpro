package com.lec.method;

import java.util.Scanner;

//����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
//(��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�.
//����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
public class Quiz01 {
	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("������ ��� ���α׷��Դϴ�. 2~9 ������ ���� �Է��ϼ��� : ");
			su = sc.nextInt();
			
		}while(su<2 && su>9);
		if(su<2 || su>9) {
			System.out.println("�߸��� ���Դϴ�. 2~9���� ���ڷ� �ٽ� �������ּ���");
		}else {
			gugu(su);
		}
		sc.close();
	}
		
		private static void gugu(int su) { // su�� 1�ʰ��� ��� su*facorial(su-1)
			int result = 0;
			for(int i=1;i<=9;i++) {
				result = su*i;
				System.out.println(su+"*"+i+"="+result);
			}
			
		}
			
}
