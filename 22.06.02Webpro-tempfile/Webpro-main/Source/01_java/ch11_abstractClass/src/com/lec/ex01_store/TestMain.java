package com.lec.ex01_store;

public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {
									new Store1("= = = 1ȣ�� = = ="),
									new Store2("= = = 2ȣ�� = = ="),
									new Store3("= = = 3ȣ�� = = =")};
		//�Ϲ� for��
		for(int idx=0 ; idx<store.length ; idx++) {
			System.out.println(store[idx].getStr());
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		//Ȯ�� for���� �������� �� ���� ��. st�� ���� ���� ����
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
