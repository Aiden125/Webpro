package st08_ex3_personinfo;

public class RetryPersonTestMain {
	public static void main(String[] args) {
		RetryPersonInfo[] newperson = new RetryPersonInfo[2];
		newperson[0] = new RetryPersonInfo("ȫ�浿", 33, '��');
		newperson[1] = new RetryPersonInfo("������", 93, '��');
		for(RetryPersonInfo p : newperson) {
			p.print();
		}
	}
}
