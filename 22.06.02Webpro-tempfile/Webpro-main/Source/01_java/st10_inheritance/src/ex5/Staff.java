package ex5;

public class Staff extends Person {
	private static int count;
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++count;
		setNo("staff"+count);
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("(°ú¸ñ)%s\n", department);
	}

}
