package test2;

public class Gangsa extends Person {
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	public void print() {
		System.out.printf("(ID)%s \t (이름)%s \t (과목)%s\n", getId(), getName(), subject);
		

	}

}
