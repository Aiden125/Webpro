package com.lec.loop;
//1~10���� ���� �� ¦�� �Ǵ� Ȥ���� ���� ���϶�
public class Quiz02 {
	public static void main(String[] args) {
		int tot = 0; //������ ����
		for(int i=1 ; i<=10 ; i++) {
			if(i%2==1) {
				tot += i;// tot = tot + i;	
			}
		}
		System.out.println("1~10���� Ȧ������ "+tot);
	}
}
