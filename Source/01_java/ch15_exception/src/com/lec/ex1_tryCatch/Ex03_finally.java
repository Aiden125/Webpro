package com.lec.ex1_tryCatch;
// finally -> try, catch문과 하나 인 것처럼 보이려고 할 때 씀
public class Ex03_finally {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2};
		for(int i=0 ; i<=arr.length ; i++) {
			try {
				System.out.println("arr[" + i + "] = " + arr[i]);				
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메시지 : " + e.getMessage());
			}finally {
				System.out.println("try절 실행 후에도 catch절 실행 후에도 여기는 반드시 실행되는 부분");
			} // try-catch-finally
		} //for
		System.out.println("프로그램 끝");
	}
}
