package st1_store;
// HeadQuarterStore hstore = new HeadQuarterStore("본사"); 객체 생성 불가(추상클래스에서)
public interface HeadQuarterStore {
	public void kimchi();
	public void bude();
	public void bibib();
	public void sunde();
	public void gonggibab();
	
	public String getStr();
}
