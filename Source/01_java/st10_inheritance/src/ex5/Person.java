package ex5;

public class Person {
	private String no;
	private String id;
	private String name;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void print() {
		System.out.printf("(��ȣ)%s \t (ID)%s \t (�̸�):%s \t ", no, id, name);
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
