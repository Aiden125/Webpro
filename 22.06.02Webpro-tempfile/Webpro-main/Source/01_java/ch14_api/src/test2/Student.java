package test2;

public class Student extends Person {
	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	
	public void print() {
		System.out.printf("(ID)%s \t (¿Ã∏ß)%s \t (π›)%s\n", getId(), getName(), ban);
		

	}

}
