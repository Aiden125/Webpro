package test2;
// id, name / print()�̳� infoString()�̳� toString() �� �ϳ�, �ʿ�ÿ� getter�� setter �޼ҵ� �߰�
public class Person {
	private String id;
	private String name;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void print() {

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
