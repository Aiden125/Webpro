package study;
public class Fibonacci1 {
	
	// 재귀함수를 통해 피보나치 수열 계산해보기
	// 자기 자신을 호출하는 함수를 만든다.
	// 뒤에서부터 계산이 되는 그림을 그려본다.
	public static int fibonacci(int number) {
		int one =1;
		int two = 1;
		int result = -1;
		if(number ==1){
			return one;
		}else if(number ==2){
			return 2;
		}else {
			for(int i = 2; i < number; i++) {
				result = one + two;
				one = two;
				two = result;
			}
		}
		return result;
	}
	
	public static void main(String[] args)  {
		 System.out.println("피보나치 수열의 10번쨰 원소는" + fibonacci(10));
	}
}
