package test2;

public class Staff extends Person {
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	public void print() {
		System.out.printf("(ID)%s \t (�̸�)%s \t (�μ�)%s\n", getId(), getName(), department);
		

	}

}
