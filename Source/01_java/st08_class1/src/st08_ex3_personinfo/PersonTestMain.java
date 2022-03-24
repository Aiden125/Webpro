package st08_ex3_personinfo;

public class PersonTestMain {
	public static void main(String[] args) {
//	그냥 출력하는 방법
//	Personinfo p1 = new Personinfo("홍길동", 23, 'm');
//	Personinfo p2 = new Personinfo("홍길동", 53, 'f');

//	배열로 하게되면 형식
//	int[] arr = new int[2];
//	Personinfo[] person = {p1, p2};
	
//	배열로 출력하는 2가지 방법
	Personinfo[] person = new Personinfo[2];
	person[0] = new Personinfo("홍길동", 22, 'm');
	person[1] = new Personinfo("홍길식", 26, 'f');
	for(int idx=0 ; idx<person.length ; idx++) {
		person[idx].print();
	}
	for(Personinfo p : person) {
		p.print();
	}
}
}
