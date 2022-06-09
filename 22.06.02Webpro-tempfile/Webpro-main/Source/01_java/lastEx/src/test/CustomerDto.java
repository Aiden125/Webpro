package test;

public class CustomerDto {
	private int cid;
	private String phone;
	private String name;
	private int point;
	

	public CustomerDto(int cid, String phone, String name, int point) {
		this.cid = cid;
		this.phone = phone;
		this.name = name;
		this.point = point;
	}


	@Override
	public String toString() {
		return cid+"\t"+phone+"\t"+name+"\t"+point;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}

}
