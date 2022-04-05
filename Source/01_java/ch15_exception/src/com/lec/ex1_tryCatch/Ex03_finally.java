package com.lec.ex1_tryCatch;
// finally -> try, catch���� �ϳ� �� ��ó�� ���̷��� �� �� ��
public class Ex03_finally {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2};
		for(int i=0 ; i<=arr.length ; i++) {
			try {
				System.out.println("arr[" + i + "] = " + arr[i]);				
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("���� �޽��� : " + e.getMessage());
			}finally {
				System.out.println("try�� ���� �Ŀ��� catch�� ���� �Ŀ��� ����� �ݵ�� ����Ǵ� �κ�");
			} // try-catch-finally
		} //for
		System.out.println("���α׷� ��");
	}
}