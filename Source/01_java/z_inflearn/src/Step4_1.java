import java.util.HashMap;
import java.util.Scanner;

public class Step4_1 {
	public static void main(String[] args) {
		Step4_1 T = new Step4_1();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		System.out.println(T.solution(n, str));
	}
	
	public char solution(int n, String str) {
		char answer = ' ';
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : str.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		int max = -1;
		for(char key : map.keySet()) {
			if(map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		return answer;
	}
}
