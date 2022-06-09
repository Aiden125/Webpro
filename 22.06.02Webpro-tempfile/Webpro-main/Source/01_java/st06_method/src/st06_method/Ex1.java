package st06_method;
//1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȥ������ ���
public class Ex1 {
	public static void main(String[] args) {
		int tot = sum(10);
		
		//1~to���� �����ϴ� ����
		//¦Ȧ �� �Ǻ�����
		System.out.println("1~10���� ��������"+tot);
		System.out.println(evenOdd(tot));
		
		// from~to �����ϴ� ����
		// ¦Ȧ�� �Ǻ� ���� �ҷ�
		tot = sum(10, 100);
		System.out.println("10~100���� ��������"+tot);
		System.out.println(evenOdd(tot));
	}
	
	private static String evenOdd(int value) {
		return value%2==0? "¦���Դϴ�" : "Ȧ���Դϴ�";
		//		String result = "null";
//		if(value%2 == 0) {
//			result = "¦���Դϴ�";
//		}else {
//			result = "Ȧ���Դϴ�";
//		}
//		return result;
	}
	
	private static int sum(int to) { // �Լ��� �����ε� �Ȱ��� �Լ����ε� �Ű������� Ÿ���̳� ������ �޸��ؼ� �ϴ� ��
		int result = 0;
		for(int i=1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	
	
	private static int sum(int from, int to) {//from~to���� ������ ��� return
		int result = 0;
		for(int i=from ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
}
