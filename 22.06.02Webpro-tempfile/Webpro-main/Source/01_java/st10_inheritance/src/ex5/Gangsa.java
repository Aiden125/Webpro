package ex5;

public class Gangsa extends Person {
	private static int count = 1;
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		count++;
		setNo("lec"+count);
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("(ºÎ¼­)%s\n", subject);
	}

}
