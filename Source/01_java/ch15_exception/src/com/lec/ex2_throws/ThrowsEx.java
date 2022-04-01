package com.lec.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception {
		actionC();			
	}
	//다 끝나면 나를 호출한 곳으로 다시 되돌아감
	//만약 객체에서 모두 쓰로우로 던진다면 사용자가 오류를 보게되기 때문에
	//최소한 메인 객체에서는 try-catch로 예외를 잡아줘야함
	//API가 쓰로우로 되어있는게 많기 때문에 이런 형태의 API를 쓸 때는
	//내가 예외처리를 해야 된다는걸 인지하고 있어야함
	private void actionC() throws Exception{
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws RuntimeException{
		System.out.println("actionB 전반부");
		actionA();			
		System.out.println("actionB 후반부");
	}
	//throws ArrayIndex~~
	//actionA에서 에러가 나올 수 있다고 나를 호출한 곳으로 던지는 것
	//그걸 받은 곳에서 처리하거나 거기서도 넘기거나
	//또, 던지게되면 그 예외부터 바로 실행 중지후 넘기게되기에 더 이상 실행x
	private void actionA() throws ArrayIndexOutOfBoundsException{
		System.out.println("actionA 전반부");
		int[] arr = {0,1,2,3};
		System.out.println(arr[4]); // 에러유발
		System.out.println("actionA 후반부");
	}
}
