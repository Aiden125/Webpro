package st1_store;
// 주택가에 매장1호점: 김치 4500 부대 5000 비빔 6000 순대 안팜  공기 1000원
public class Store1 implements HeadQuarterStore {//추상 클래스 적용시 stroe1에 마우스 갖다대고 ctrl+1눌러서도 가능
	//본사
	private String str;
	//매개변수 1개 있는 생성자
	public Store1(String str) {
		this.str = str;
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 4,500원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 - 6,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");
	}
	public String getStr() {
		return str;
	}

	
}
