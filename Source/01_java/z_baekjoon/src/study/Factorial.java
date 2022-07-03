package study;
public class Factorial {
	
	// 재귀함수를 통해 팩토리얼 계산해보기
	// 자기 자신을 호출하는 함수를 만든다.
	// 뒤에서부터 계산이 되는 그림을 그려본다.
	public static int factorial(int number) {
		if(number == 1) {
			return 1;
		}else {
			return number * factorial(number -1);
		}
	}
	
	public static void main(String[] args)  {
		 System.out.println("10팩토리얼은 " + factorial(10));
	}
}
