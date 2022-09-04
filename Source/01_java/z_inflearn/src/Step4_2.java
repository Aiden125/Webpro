import java.util.HashMap;
import java.util.Scanner;

public class Step4_2 {
	public static void main(String[] args) {
		Step4_2 T = new Step4_2();
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.println(T.solution(a, b));
	}
	
	public String solution(String a, String b) {
		String answer = "YES";
		HashMap<Character, Integer> map = new HashMap<>();
		for(char x : a.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		for(char x : b.toCharArray()) {
			if(!map.containsKey(x) || map.get(x)==0) {
				return "NO";
			}
			map.put(x, map.get(x)-1);
		}
		
		return answer;
	}
}
