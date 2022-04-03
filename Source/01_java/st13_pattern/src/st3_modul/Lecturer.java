package st3_modul;

import st3.GetSalary;
import st3.JobLec;

public class Lecturer extends Person {
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec()); //���Ǹ� �մϴ�. ���
		setGet(new GetSalary()); //������ �޽��ϴ�. ���
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("(���ǰ���)%s", getSubject());
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
