package test2;

public class Gangsa extends Person {
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	public void print() {
		System.out.printf("(ID)%s \t (�̸�)%s \t (����)%s\n", getId(), getName(), subject);
		

	}

}
