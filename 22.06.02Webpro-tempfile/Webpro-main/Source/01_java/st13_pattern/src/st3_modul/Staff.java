package st3_modul;

import st3.*;

public class Staff extends Person {
	private String part;
	
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.printf("(ºÎ¼­)%s", getPart());
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	
}
