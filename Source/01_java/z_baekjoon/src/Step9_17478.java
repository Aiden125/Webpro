import java.util.Scanner;

// �� static�� ��� �ϴ°�?
// ���� �ùٸ� ����ΰ�?
public class Step9_17478{
	public static void main(String[] args) {
		 int n;
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		 proffessor(n);
	}
	
	
	static String line="";
	public static void proffessor(int n) {
		String underline = line;
		if(n==0) {
			System.out.println(underline + "\"����Լ��� ������?\"");
			System.out.println(underline + "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(underline + "��� �亯�Ͽ���.");
			return;
		}else{
			System.out.println(underline + "\"����Լ��� ������?\"");
			System.out.println(underline + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.println(underline + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.println(underline + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			line += "____";
			proffessor(n-1);
			System.out.println(underline + "��� �亯�Ͽ���.");
		}
	}
}
