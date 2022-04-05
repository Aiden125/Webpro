package st4_demo;
// 이름 번호 주소 데이터를 갖는 배열을 각각 ArrayList, HashMap에 넣어 출력.
// 중단여부 받기, 종료후 아무것도 없으면 아무것도 없다고 출력. 있으면 있는 배열 출력
// 전화번호가 중복되면 다시 되묻는 로직도 구성해보기
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
		return "이름 : "+name+"\t번호 : "+tel+"\t 주소 : "+address;
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
