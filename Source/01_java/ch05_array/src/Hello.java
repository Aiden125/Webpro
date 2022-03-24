// Hello.java -> compile(javac Hello.java) -> Hello.class -> 실행(java Hello 장동건 고소영) --> result
public class Hello {
	public static void main(String[] args) {
		System.out.println("안녕하세요");
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println("," + args[idx]);
		}
	}
}
