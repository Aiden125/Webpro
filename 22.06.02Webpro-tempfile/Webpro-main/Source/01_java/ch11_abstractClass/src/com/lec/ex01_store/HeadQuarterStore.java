package com.lec.ex01_store;
//본사 지침         : 김치찌개-000  부대찌개-000  비빔밥-000 순대국-000  공기밥-000원
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원

// HeadQuarterStore hstore = new HeadQuarterStore("본사"); 객체 생성 불가(추상클래스에서)
public abstract class HeadQuarterStore {
	private	String str; //"본사"
	
	//생성자 라인(매개변수 1개 있는거)
	public HeadQuarterStore(String str) {
		this.str = str;
	}
	
	//메소드 구현은 없고 선언만 되어 있는 메소드 : 추상 메소드(상속받은 클래스에서 오버라이드 해야함)
	//클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	
	// getter&setter 라인
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
