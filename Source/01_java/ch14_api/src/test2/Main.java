package test2;

public class Main {
	public static void main(String[] args) {
		Person[] persons = {
				new Student("A01", "���л�", "JAVA��"),
				new Student("A02", "ȫ�浿", "C++��"),
				new Staff("S01", "������", "������"),
				new Staff("S02", "������", "���������"),
				new Gangsa("G01", "������", "���α׷���")};
		
		for(Person p : persons) {
			p.print();
		}
	}
}
