package st08_ex3_personinfo;

public class PersonTestMain {
	public static void main(String[] args) {
//	�׳� ����ϴ� ���
//	Personinfo p1 = new Personinfo("ȫ�浿", 23, 'm');
//	Personinfo p2 = new Personinfo("ȫ�浿", 53, 'f');

//	�迭�� �ϰԵǸ� ����
//	int[] arr = new int[2];
//	Personinfo[] person = {p1, p2};
	
//	�迭�� ����ϴ� 2���� ���
	Personinfo[] person = new Personinfo[2];
	person[0] = new Personinfo("ȫ�浿", 22, 'm');
	person[1] = new Personinfo("ȫ���", 26, 'f');
	for(int idx=0 ; idx<person.length ; idx++) {
		person[idx].print();
	}
	for(Personinfo p : person) {
		p.print();
	}
}
}
