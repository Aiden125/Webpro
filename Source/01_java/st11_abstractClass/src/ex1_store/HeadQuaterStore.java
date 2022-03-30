package ex1_store;
//본사 지침         : 김치찌개-000  부대찌개-000  비빔밥-000 순대국-000  공기밥-000원
//주택가에 매장1호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-6,000 순대국-안팔아 공기밥-1,000원
//대학가에 매장2호점: 김치찌개-5,000  부대찌개-5,000  비빔밥-5,000 순대국-5,000  공기밥-무료
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public abstract class HeadQuaterStore {
	//data
	private String store; //"본사"
	
	//constructor
	public HeadQuaterStore(String store) {
		this.store = store;
	}
	
	//method
	public abstract void kimchi();
	public abstract void bude();
	public abstract void bibib();
	public abstract void sunde();
	public abstract void gonggibab();
	
	//get, set
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	
	
}
