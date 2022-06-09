package st08_ex3_personinfo;

public class RetryPersonTestMain {
	public static void main(String[] args) {
		RetryPersonInfo[] newperson = new RetryPersonInfo[2];
		newperson[0] = new RetryPersonInfo("홍길동", 33, '남');
		newperson[1] = new RetryPersonInfo("남지동", 93, '여');
		for(RetryPersonInfo p : newperson) {
			p.print();
		}
	}
}
