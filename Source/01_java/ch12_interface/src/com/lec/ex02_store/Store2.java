package com.lec.ex02_store;
//대학가에 매장2호점: 김치 5 부대 5 비빔 5 순대 5 공기-무료
public class Store2 extends HeadQuarterStore {
	
	private String str;
	public Store2(String str) {
		this.str = str;
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 - 5,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 무료");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 - 5,000원");
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
