package study;
public class Fibonacci1 {
	
	// ����Լ��� ���� �Ǻ���ġ ���� ����غ���
	// �ڱ� �ڽ��� ȣ���ϴ� �Լ��� �����.
	// �ڿ������� ����� �Ǵ� �׸��� �׷�����.
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
		 System.out.println("�Ǻ���ġ ������ 10���� ���Ҵ�" + fibonacci(10));
	}
}
