package st4_demo;
// �̸� ��ȣ �ּ� �����͸� ���� �迭�� ���� ArrayList, HashMap�� �־� ���.
// �ߴܿ��� �ޱ�, ������ �ƹ��͵� ������ �ƹ��͵� ���ٰ� ���. ������ �ִ� �迭 ���
// ��ȭ��ȣ�� �ߺ��Ǹ� �ٽ� �ǹ��� ������ �����غ���
public class Member {
	private String name;
	private String tel;
	private String address;
	
	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	@Override
	public String toString() {
		return "�̸� : "+name+"\t��ȣ : "+tel+"\t �ּ� : "+address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}