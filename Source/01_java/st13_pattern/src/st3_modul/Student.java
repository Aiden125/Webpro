package st3_modul;

import st3.*;

public class Student extends Person {
	private String ban;
	
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf("(¹Ý)%s",ban);
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
	
}
