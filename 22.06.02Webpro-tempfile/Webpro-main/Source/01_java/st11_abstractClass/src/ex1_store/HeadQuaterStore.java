package ex1_store;
//���� ��ħ         : ��ġ�-000  �δ��-000  �����-000 ���뱹-000  �����-000��
//���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
//���а��� ����2ȣ��: ��ġ�-5,000  �δ��-5,000  �����-5,000 ���뱹-5,000  �����-����
//���ǰ��� ����3ȣ��: ��ġ�-6,000  �δ��-7,000  �����-7,000 ���뱹-6,000  �����-1,000��
public abstract class HeadQuaterStore {
	//data
	private String store; //"����"
	
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
