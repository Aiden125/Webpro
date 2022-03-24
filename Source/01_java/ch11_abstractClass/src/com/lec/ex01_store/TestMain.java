package com.lec.ex01_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {
									new Store1("= = = 1호점 = = ="),
									new Store2("= = = 2호점 = = ="),
									new Store3("= = = 3호점 = = =")};
		//일반 for문
		for(int idx=0 ; idx<store.length ; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		//확장 for문이 가독성이 더 높은 편. st는 임의 변수 지정
		for(HeadQuarterStore st : store) {
			System.out.println(st.getStr());
			st.kimchi();
			st.bude();
			st.bibib();
			st.sunde();
			st.gonggibab();
		}
}
}
