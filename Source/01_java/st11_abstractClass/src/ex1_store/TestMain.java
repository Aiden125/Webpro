package ex1_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuaterStore st1 = new Store1("----1호점----");
		HeadQuaterStore st2 = new Store2("----2호점----");
		HeadQuaterStore st3 = new Store3("----3호점----");
		
		HeadQuaterStore stores[] = {st1, st2, st3};
		for(HeadQuaterStore a : stores) {
			System.out.println(a.getStore());
			a.bibib();
			a.bude();
			a.kimchi();
			a.sunde();
			a.gonggibab();
		}
	}
}
