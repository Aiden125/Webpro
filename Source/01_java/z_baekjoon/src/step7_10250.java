import java.util.Scanner;

public class step7_10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // ����Ʈ ���̽�
		
		for(int i=0; i<T; i++) {
			int H = sc.nextInt(); // ����
			int W = sc.nextInt(); // ����
			int N = sc.nextInt(); // ���° �մ�����
			if(N%H == 0) {
				System.out.print(H*100);
			}else {
				System.out.print(N%H);				
			}
			if(N/H < 9) {
				System.out.println("0"+((N/H)+1));							
			}else {
				System.out.println((N/H)+1);											
			}
		}
	}
}
