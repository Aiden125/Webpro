package com.lec.ex12_store;
//본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class HeadQuarterStore {
	private	String str; //"본사"
	
	//생성자 라인(매개변수 1개 있는거)
	public HeadQuarterStore(String str) {
		this.str = str;
	}
	
	//메소드 5개 각 메뉴 별로
	public void kimchi() {
		System.out.println("김치찌개 - 5,000원");
	}
	public void bude() {
		System.out.println("부대찌개 - 6,000원");
	}
	public void bibib() {
		System.out.println("비빔밥 - 6,000원");
	}
	public void sunde() {
		System.out.println("순대국 - 5,000원");
	}
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");
	}
	
	// getter&setter 라인
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
