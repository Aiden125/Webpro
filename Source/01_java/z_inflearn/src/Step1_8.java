import java.util.Scanner;

public class Step1_8 {
	public static void main(String[] args) {
		Step1_8 T = new Step1_8();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(T.solution(str));
	}
	
	public String solution(String str) {
		String answer = "NO";
		String temp;
		StringBuilder sb = new StringBuilder();
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		temp = sb.append(str).reverse().toString();
		if(temp.equals(str)) {
			answer = "YES";
		}
		return answer;
	}
}
