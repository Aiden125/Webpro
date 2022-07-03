package study;
public class Fibonacci2 {
	
	// 재귀함수를 통해 피보나치 수열 계산해보기
	// 자기 자신을 호출하는 함수를 만든다.
	// 뒤에서부터 계산이 되는 그림을 그려본다.
	
	// 재귀함수는 이전에 값을 필요로 하기 때문에 큰 값을 넣으면 시간이 굉장히
	// 오래 걸리는 치명적 오류를 가지고 있다.
	public static int fibonacci(int number) {
		if(number ==1){
			return 1;
		}else if(number ==2){
			return 1;
		}else {
			return fibonacci(number -1) + fibonacci(number -2);
		}
	}
	
	public static void main(String[] args)  {
		 System.out.println("피보나치 수열의 10번쨰 원소는" + fibonacci(30));
	}
}
