// Hello.java -> compile(javac Hello.java) -> Hello.class -> ����(java Hello �嵿�� ��ҿ�) --> result
public class Hello {
	public static void main(String[] args) {
		System.out.println("�ȳ��ϼ���");
		for(int idx=0 ; idx<args.length ; idx++) {
			System.out.println("," + args[idx]);
		}
	}
}
