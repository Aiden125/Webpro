package st08_ex3_personinfo;
//
public class RetryPersonInfo {
	private String name;
	private int age;
	private char gender;
	
	public RetryPersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void print() {
		System.out.printf("�̸�=%s, ����=%d, ����=%c\n", name, age, gender);
	}
	
	
}
