import java.util.Scanner;

public class Step1_11 {
	public static void main(String[] args) {
		Step1_11 T = new Step1_11();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "";

		int count = 0;
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=i; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					count++;
				}else {
					if(count == 0) {
						answer += str.charAt(i);
						continue;
					}else {
						answer += str.charAt(i)+""+count;
						count = 0;
						continue;
					}
				}
			}
		}
		return answer;
	}
}
