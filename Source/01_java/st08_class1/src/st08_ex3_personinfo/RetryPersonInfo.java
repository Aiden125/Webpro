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
		System.out.printf("이름=%s, 나이=%d, 성별=%c\n", name, age, gender);
	}
	
	
}
