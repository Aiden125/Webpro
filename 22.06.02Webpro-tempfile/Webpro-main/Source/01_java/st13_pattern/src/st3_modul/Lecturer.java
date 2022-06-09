package st3_modul;

import st3.GetSalary;
import st3.JobLec;

public class Lecturer extends Person {
	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec()); //강의를 합니다. 출력
		setGet(new GetSalary()); //월급을 받습니다. 출력
	}
	@Override
	public void print() {
		super.print();
		System.out.printf("(강의과목)%s", getSubject());
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
