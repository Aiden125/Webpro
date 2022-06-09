package test2;

public class Staff extends Person {
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	public void print() {
		System.out.printf("(ID)%s \t (이름)%s \t (부서)%s\n", getId(), getName(), department);
		

	}

}
